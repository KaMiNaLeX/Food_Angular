package com.example.food.repositories;

import com.example.food.models.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT * FROM MENU ", countQuery = "SELECT COUNT(*) FROM MENU ", nativeQuery = true)
    Page<Map<String, Object>> findAllMenu(Pageable pageable);
}

