package org.company.repository;

import org.company.dao.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
