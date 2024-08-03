package com.tri.trispring.repository;

import com.tri.trispring.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EntityRepository extends JpaRepository<Entity,Integer> {

    Set<Entity> getDistinctByTravelNumber(String travelNumber);
}
