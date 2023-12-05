package org.company;

import org.company.dao.entity.Travel;
import org.company.dao.entity.Vehicle;
import org.company.repository.TravelRepository;
import org.company.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TravelRepositoryTest {

    @Autowired
    TravelRepository travelRepository;
    @Test
    @Transactional
    public void getVehicleById(){
        Travel travel = travelRepository.getReferenceById(1);
        assertNotNull(travel);
        String expected = "2023-12-03";
        String actual = travel.getTravelDate().toString();
        Assertions.assertEquals(expected,actual);
        System.out.println(travel);
    }
}
