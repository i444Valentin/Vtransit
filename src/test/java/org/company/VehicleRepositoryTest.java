package org.company;

import org.company.dao.entity.Vehicle;
import org.company.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VehicleRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;
    @Test
    @Transactional
    public void getVehicleById(){
        Vehicle vehicle = vehicleRepository.getReferenceById(4);
        assertNotNull(vehicle);
        String expected = "Легковой";
        String actual = vehicle.getVehicleType();
        Assertions.assertEquals(expected,actual);
        System.out.println(vehicle);
    }
}
