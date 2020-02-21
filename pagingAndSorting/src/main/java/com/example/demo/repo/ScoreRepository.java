package com.example.demo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.CibilScore;

public interface ScoreRepository extends PagingAndSortingRepository<CibilScore, String> {

}
