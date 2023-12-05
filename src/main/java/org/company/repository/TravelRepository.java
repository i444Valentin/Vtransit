package org.company.repository;

import org.company.dao.entity.Driver;
import org.company.dao.entity.Travel;
import org.company.dao.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelRepository extends JpaRepository<Travel,Integer> {
    Optional<Travel> findByVehicle(Vehicle vehicle);
    Optional<Travel> findByDriver(Driver driver);
}
