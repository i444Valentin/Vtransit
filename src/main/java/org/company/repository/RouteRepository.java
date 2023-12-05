package org.company.repository;

import org.company.dao.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Integer> {
}
