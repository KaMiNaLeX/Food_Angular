package com.example.food.repositories;

import com.example.food.models.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query(value = "SELECT S.id,S.dish_id, D.description,D.mass,D.name,D.img_source,D.menu_id, M.category,M.cost FROM SHOPPING_CART S " +
            "INNER JOIN DISHES D ON D.id = S.dish_id " +
            "INNER JOIN MENU M ON M.id = D.menu_id " +
            "INNER JOIN CLIENTS C ON C.id = S.client_id " +
            " WHERE C.login =:LOGIN"
            , countQuery = "SELECT COUNT(*) FROM SHOPPING_CART S " +
            "INNER JOIN DISHES D ON D.id = S.dish_id " +
            "INNER JOIN MENU M ON M.id = D.menu_id " +
            "INNER JOIN CLIENTS C ON C.id = S.client_id " +
            " WHERE C.login =:LOGIN", nativeQuery = true)
    List<Map<String, Object>> getByClientLogin(@Param("LOGIN") String login);

    @Query(value = "SELECT * FROM shopping_cart ",
            countQuery = "SELECT COUNT(*) FROM shopping_cart ", nativeQuery = true)
    Page<Map<String, Object>> findAllShoppingCart (Pageable pageable);

}
