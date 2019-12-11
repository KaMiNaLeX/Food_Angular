package com.example.food.repositories;

import com.example.food.models.ClientsDishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsDishesRepository extends JpaRepository<ClientsDishes, Long> {
    List<ClientsDishes> findByClientId(Long clientId);

    List<ClientsDishes> getByOrderId(Long orderId);
}
