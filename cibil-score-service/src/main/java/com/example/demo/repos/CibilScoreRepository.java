package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CibilScore;

@Repository

public interface CibilScoreRepository extends JpaRepository<CibilScore, String> {

}
