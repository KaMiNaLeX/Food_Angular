package com.example.food.repositories;

import com.example.food.dto.ClientsDto;
import com.example.food.models.Clients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {
    @Query(value = "SELECT * FROM CLIENTS ", countQuery = "SELECT COUNT(*) FROM CLIENTS ", nativeQuery = true)
    Page<Map<String, Object>> findAllClients(Pageable pageable);

    @Query(value = "SELECT C.ID ,C.LOGIN,C.PHONE,C.ADDRESS,C.SURNAME,C.PASSWORD FROM CLIENTS C WHERE C.LOGIN=:LOGIN",
            countQuery = "SELECT COUNT(*) FROM CLIENTS C WHERE C.LOGIN=:LOGIN", nativeQuery = true)
    List<Map<String, Object>> getByLogin(@Param("LOGIN") String login);

    Clients findByLogin(String login);

    @Query(value = "SELECT C.ID FROM CLIENTS C WHERE C.LOGIN=:LOGIN",
            countQuery = "SELECT COUNT(*) FROM CLIENTS C WHERE C.LOGIN=:LOGIN", nativeQuery = true)
    Map<String, Object> getIdByLogin(@Param("LOGIN") String login);


}
