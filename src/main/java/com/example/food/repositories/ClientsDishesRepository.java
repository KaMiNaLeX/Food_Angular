package com.example.food.repositories;

import com.example.food.models.ClientsDishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsDishesRepository extends JpaRepository<ClientsDishes, Long> {
}
