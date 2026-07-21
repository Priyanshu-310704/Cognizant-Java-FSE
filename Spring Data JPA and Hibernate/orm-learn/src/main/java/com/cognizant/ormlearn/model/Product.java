package com.cognizant.ormlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer customerReview;
    private String hardDiskSize;
    private String ramSize;
    private Double cpuSpeed;
    private String operatingSystem;
    private Double weight;
    private String cpu;

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getCustomerReview() { return customerReview; }
    public String getHardDiskSize() { return hardDiskSize; }
    public String getRamSize() { return ramSize; }
    public Double getCpuSpeed() { return cpuSpeed; }
    public String getOperatingSystem() { return operatingSystem; }
    public Double getWeight() { return weight; }
    public String getCpu() { return cpu; }
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCustomerReview(Integer customerReview) { this.customerReview = customerReview; }
    public void setHardDiskSize(String hardDiskSize) { this.hardDiskSize = hardDiskSize; }
    public void setRamSize(String ramSize) { this.ramSize = ramSize; }
    public void setCpuSpeed(Double cpuSpeed) { this.cpuSpeed = cpuSpeed; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }
    public void setWeight(Double weight) { this.weight = weight; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', ramSize='" + ramSize + "', operatingSystem='" + operatingSystem + "'}";
    }
}
