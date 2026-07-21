package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Product;
import com.cognizant.ormlearn.model.ProductSearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductSearchService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Product> search(ProductSearchCriteria criteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.keyword() != null && !criteria.keyword().isBlank()) {
            predicates.add(builder.like(builder.lower(product.get("name")), "%" + criteria.keyword().toLowerCase() + "%"));
        }
        if (criteria.minimumCustomerReview() != null) {
            predicates.add(builder.greaterThanOrEqualTo(product.get("customerReview"), criteria.minimumCustomerReview()));
        }
        if (criteria.hardDiskSize() != null) {
            predicates.add(builder.equal(product.get("hardDiskSize"), criteria.hardDiskSize()));
        }
        if (criteria.ramSize() != null) {
            predicates.add(builder.equal(product.get("ramSize"), criteria.ramSize()));
        }
        if (criteria.minimumCpuSpeed() != null) {
            predicates.add(builder.greaterThanOrEqualTo(product.get("cpuSpeed"), criteria.minimumCpuSpeed()));
        }
        if (criteria.operatingSystem() != null) {
            predicates.add(builder.equal(product.get("operatingSystem"), criteria.operatingSystem()));
        }
        if (criteria.maximumWeight() != null) {
            predicates.add(builder.lessThanOrEqualTo(product.get("weight"), criteria.maximumWeight()));
        }
        if (criteria.cpu() != null) {
            predicates.add(builder.equal(product.get("cpu"), criteria.cpu()));
        }

        query.select(product).where(predicates.toArray(Predicate[]::new));
        return entityManager.createQuery(query).getResultList();
    }
}
