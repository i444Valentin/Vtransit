package org.company;

import org.company.dao.entity.Route;
import org.company.dao.entity.Vehicle;
import org.company.repository.RouteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RouteRepositoryTest {

    @Autowired
    RouteRepository routeRepository;

    @Test
    @Transactional
    public void getRouteById(){
        Route route = routeRepository.getReferenceById(1);
        assertNotNull(route);
        String expected = "г. Пенза";
        String actual = route.getDeparture().getCity();
        Assertions.assertEquals(expected,actual);
        System.out.println(route);
    }
}
