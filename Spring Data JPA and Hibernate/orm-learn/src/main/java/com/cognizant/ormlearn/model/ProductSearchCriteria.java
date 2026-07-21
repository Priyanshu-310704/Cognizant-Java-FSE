package com.cognizant.ormlearn.model;

public record ProductSearchCriteria(
        String keyword,
        Integer minimumCustomerReview,
        String hardDiskSize,
        String ramSize,
        Double minimumCpuSpeed,
        String operatingSystem,
        Double maximumWeight,
        String cpu) {
}
