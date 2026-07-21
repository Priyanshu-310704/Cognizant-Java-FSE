package com.cognizant.microservice.gateway.filter;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ResponseCacheMarkerFilter implements GlobalFilter, Ordered {
    private final Set<String> seenGetRequests = ConcurrentHashMap.newKeySet();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (exchange.getRequest().getMethod() == HttpMethod.GET) {
            String key = exchange.getRequest().getURI().toString();
            String status = seenGetRequests.add(key) ? "MISS" : "HIT";
            exchange.getResponse().getHeaders().add("X-Local-Cache", status);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -80;
    }
}
