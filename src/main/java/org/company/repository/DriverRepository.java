package org.company.repository;

import org.company.dao.entity.Driver;
import org.company.dao.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query("SELECT d FROM Driver d WHERE d.license = :license")
    Optional<Driver> findByLicense(License license);
}
