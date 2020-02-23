package com.example.demo.repo;

import com.example.demo.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Integer> {


    public List<Food> findAllByCuisine(String cuisine);
}
