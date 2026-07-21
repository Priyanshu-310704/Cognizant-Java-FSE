package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public List<Stock> findByCodeAndMonth(String code, LocalDate start, LocalDate end) {
        return stockRepository.findByCodeAndDateBetweenOrderByDateAsc(code, start, end);
    }

    @Transactional(readOnly = true)
    public List<Stock> findByCodeAndCloseGreaterThan(String code, double close) {
        return stockRepository.findByCodeAndCloseGreaterThanOrderByDateAsc(code, close);
    }

    @Transactional(readOnly = true)
    public List<Stock> findTop3ByVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional(readOnly = true)
    public List<Stock> findLowest3ByCode(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}
