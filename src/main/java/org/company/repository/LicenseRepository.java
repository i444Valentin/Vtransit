package org.company.repository;

import org.company.dao.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LicenseRepository extends JpaRepository<License,Integer> {

}
