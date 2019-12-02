package com.example.food.repositories;

import com.example.food.models.Dishes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DishRepository extends JpaRepository<Dishes, Long> {
    @Query(value = "SELECT * FROM DISHES ", countQuery = "SELECT COUNT(*) FROM DISHES ", nativeQuery = true)
    Page<Map<String, Object>> findAllDishes(Pageable pageable);

    @Query(value = "SELECT D.id,D.description,D.mass,D.name,D.img_source,M.category,M.cost FROM DISHES D " +
            "INNER JOIN MENU M ON D.menu_id = M.id ", countQuery = "SELECT COUNT(*) FROM DISHES D " +
            "INNER JOIN MENU M ON D.menu_id = M.id ", nativeQuery = true)
    Page<Map<String, Object>> findAllDishesMenu(Pageable pageable);

    @Query(value = "SELECT  D.id,D.description,D.mass,D.name,D.img_source,M.category, M.cost FROM DISHES D " +
            "INNER JOIN MENU M ON D.menu_id = M.id WHERE M.category=:category", countQuery = "SELECT COUNT(*) FROM DISHES D " +
            "INNER JOIN MENU M ON D.menu_id = M.id WHERE M.category=:category", nativeQuery = true)
    List<Map<String, Object>> getByCategory(@Param("category") String category);

    @Query(value = "SELECT  D.id,D.description,D.mass,D.name,D.img_source,M.category, M.cost FROM DISHES D " +
            "INNER JOIN MENU M ON D.menu_id = M.id WHERE D.id=:id", countQuery = "SELECT COUNT(*) FROM DISHES D " +
            "INNER JOIN MENU M ON D.menu_id = M.id WHERE D.id=:id", nativeQuery = true)
    Map<String, Object> ById(@Param("id") Long id);
}
