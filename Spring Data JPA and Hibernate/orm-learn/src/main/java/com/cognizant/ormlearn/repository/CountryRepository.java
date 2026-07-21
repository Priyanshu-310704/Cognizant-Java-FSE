package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    List<Country> findByNameStartingWithIgnoreCaseOrderByNameAsc(String prefix);

    @Query("select c from Country c where lower(c.name) like lower(concat('%', :text, '%')) order by c.name")
    List<Country> searchByName(@Param("text") String text);
}
