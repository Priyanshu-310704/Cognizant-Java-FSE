package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCodeAndDateBetweenOrderByDateAsc(String code, LocalDate start, LocalDate end);

    List<Stock> findByCodeAndCloseGreaterThanOrderByDateAsc(String code, double close);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
