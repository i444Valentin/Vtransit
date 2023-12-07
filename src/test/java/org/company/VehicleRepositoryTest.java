package org.company;

import org.company.dao.entity.Servicing;
import org.company.dao.entity.Vehicle;
import org.company.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

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

    @Test
    @Transactional
    @Commit
    public void addNewVehicle(){
        Servicing servicing = new Servicing()
                .setCommonState("Необходимо обслужить")
                .setEngineState("Необходимо обслужить")
                .setTransmissionState("Необходимо обслужить")
                .setVehicle(null)
                .setTraveled(0)
                .setLastService(LocalDate.now());
        Vehicle vehicle = new Vehicle()
                .setVehicleType("Внедорожник")
                .setGosNumSign("A849MM")
                .setModel("Big Boy 8C")
                .setManufactured("2010")
                .setServicing(servicing);
        servicing.setVehicle(vehicle);

        Integer tabelNumber = vehicleRepository.save(vehicle).getTabelNumber();

        Vehicle actual = vehicleRepository.getReferenceById(tabelNumber);

        Assertions.assertEquals(vehicle,actual);
        System.out.println(actual);
//        vehicleRepository.delete(actual);
    }

    @Test
    @Transactional
    @Commit
    public void updateVehicle(){
        Servicing servicing = new Servicing()
                .setTabelNumber(19)
                .setCommonState("Необходимо обслужить")
                .setEngineState("Необходимо обслужить")
                .setTransmissionState("Необходимо обслужить")
                .setVehicle(null)
                .setTraveled(0)
                .setLastService(LocalDate.now());
        Vehicle vehicle = new Vehicle()
                .setTabelNumber(19)
                .setVehicleType("Внедорожник")
                .setGosNumSign("A849MM")
                .setModel("Big Boy 8C")
                .setManufactured("2010")
                .setServicing(servicing);
        servicing.setVehicle(vehicle);

        Integer tabelNumber = vehicleRepository.save(vehicle).getTabelNumber();

        Vehicle actual = vehicleRepository.getReferenceById(tabelNumber);

        Assertions.assertEquals(vehicle,actual);
        System.out.println(actual);
    }
}
