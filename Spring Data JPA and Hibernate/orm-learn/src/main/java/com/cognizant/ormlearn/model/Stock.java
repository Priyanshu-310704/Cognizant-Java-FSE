package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private Integer id;

    @Column(name = "st_code", length = 10)
    private String code;

    @Column(name = "st_date")
    private LocalDate date;

    @Column(name = "st_open")
    private double open;

    @Column(name = "st_close")
    private double close;

    @Column(name = "st_volume")
    private long volume;

    public Integer getId() { return id; }
    public String getCode() { return code; }
    public LocalDate getDate() { return date; }
    public double getOpen() { return open; }
    public double getClose() { return close; }
    public long getVolume() { return volume; }
    public void setId(Integer id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setOpen(double open) { this.open = open; }
    public void setClose(double close) { this.close = close; }
    public void setVolume(long volume) { this.volume = volume; }

    @Override
    public String toString() {
        return "Stock{id=" + id + ", code='" + code + "', date=" + date + ", close=" + close + ", volume=" + volume + "}";
    }
}
