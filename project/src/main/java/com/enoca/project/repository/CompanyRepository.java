package com.enoca.project.repository;

import com.enoca.project.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT c FROM Company c ORDER BY c.id ASC")
    List<Company> findAllCompanies();
}
