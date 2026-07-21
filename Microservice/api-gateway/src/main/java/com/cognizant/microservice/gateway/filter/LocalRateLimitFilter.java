package com.cognizant.microservice.gateway.filter;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LocalRateLimitFilter implements GlobalFilter, Ordered {
    private static final int LIMIT_PER_MINUTE = 60;
    private final Map<String, WindowCounter> counters = new ConcurrentHashMap<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String key = exchange.getRequest().getRemoteAddress() == null
                ? "unknown"
                : exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        WindowCounter counter = counters.computeIfAbsent(key, ignored -> new WindowCounter());
        if (!counter.tryAcquire()) {
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -90;
    }

    private static class WindowCounter {
        private volatile long minute = Instant.now().getEpochSecond() / 60;
        private final AtomicInteger count = new AtomicInteger();

        synchronized boolean tryAcquire() {
            long currentMinute = Instant.now().getEpochSecond() / 60;
            if (currentMinute != minute) {
                minute = currentMinute;
                count.set(0);
            }
            return count.incrementAndGet() <= LIMIT_PER_MINUTE;
        }
    }
}
