package com.example.food.repositories;

import com.example.food.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT O.id ,O.time_order, C.login,C.PHONE,C.ADDRESS,O.sum FROM CLIENTS C " +
            "INNER JOIN ORDERS O  ON O.CLIENT_ID = C.ID WHERE C.LOGIN=:LOGIN", countQuery = "SELECT COUNT(*) FROM CLIENTS C " +
            "INNER JOIN ORDERS O ON O.CLIENT_ID = C.ID WHERE C.LOGIN=:LOGIN", nativeQuery = true)
    List<Map<String, Object>> getByLogin(@Param("LOGIN") String login);

    @Query(value = "SELECT * FROM ORDERS ",
            countQuery = "SELECT COUNT(*) FROM ORDERS ", nativeQuery = true)
    Page<Map<String, Object>> findAllOrders(Pageable pageable);

    @Query(value = "SELECT O.ID,O.SUM,O.TIME_ORDER, " +
    "D.NAME,D.DESCRIPTION,D.img_source, M.CATEGORY FROM CLIENTS C " +
    "INNER JOIN ORDERS O ON C.ID = O.CLIENT_ID " +
    "INNER JOIN CLIENTS_DISHES CD ON CD.ORDER_ID = O.ID " +
    "INNER JOIN DISHES D ON D.ID = CD.DISH_ID " +
    "INNER JOIN MENU M ON D.MENU_ID = M.ID WHERE C.LOGIN=:LOGIN",
    countQuery = "SELECT COUNT (*) FROM CLIENTS C " +
            "INNER JOIN ORDERS O ON C.ID = O.CLIENT_ID " +
            "INNER JOIN CLIENTS_DISHES CD ON CD.ORDER_ID = O.ID " +
            "INNER JOIN DISHES D ON D.ID = CD.DISH_ID " +
            "INNER JOIN MENU M ON D.MENU_ID = M.ID " +
            "WHERE C.LOGIN=:LOGIN ", nativeQuery = true)
    List<Map<String, Object>> getDishesByLogin(@Param("LOGIN") String login);

    @Query(value = "SELECT D.name,D.description,D.mass,D.img_source,M.category,M.cost,O.id,O.client_id,O.sum,O.time_order" +
            " FROM CLIENTS C " +
            "INNER JOIN ORDERS O ON C.ID = O.CLIENT_ID " +
            "INNER JOIN CLIENTS_DISHES CD ON CD.ORDER_ID = O.ID " +
            "INNER JOIN DISHES D ON D.ID = CD.DISH_ID " +
            "INNER JOIN MENU M ON D.MENU_ID = M.ID WHERE O.ID =:ORDERID ",
            countQuery = "SELECT COUNT (*) FROM CLIENTS C " +
                    "INNER JOIN ORDERS O ON C.ID = O.CLIENT_ID " +
                    "INNER JOIN CLIENTS_DISHES CD ON CD.ORDER_ID = O.ID " +
                    "INNER JOIN DISHES D ON D.ID = CD.DISH_ID " +
                    "INNER JOIN MENU M ON D.MENU_ID = M.ID " +
                    "WHERE O.ID=:ORDERID", nativeQuery = true)
    List<Map<String, Object>> getDishesByOrderId(@Param("ORDERID") Long orderId);

}
