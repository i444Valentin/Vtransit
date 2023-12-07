package org.company;

import org.company.dao.entity.Payment;
import org.company.dao.entity.Travel;
import org.company.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TravelRepositoryTest {

    @Autowired
    TravelRepository travelRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @Test
    @Transactional
    public void getTravelById(){
        Travel travel = travelRepository.getReferenceById(1);
        assertNotNull(travel);
        String expected = "2023-12-03";
        String actual = travel.getTravelDate().toString();
        Assertions.assertEquals(expected,actual);
        System.out.println(travel);
    }

    @Test
    @Transactional
    public void addNewTravel(){
        Integer travelNumber = 5;

        Travel travel = new Travel()
                .setTravelDate(LocalDate.now())
                .setDriver(driverRepository.getReferenceById(7))
                .setRoute(routeRepository.getReferenceById(1))
                .setVehicle(vehicleRepository.getReferenceById(6))
                .setPayment(null)
                .setStarted(LocalTime.now())
                .setTaskDescription("Перевозка подарка другу");

        Payment payment = new Payment()
                .setTravel(travel)
                .setBonus(BigDecimal.valueOf(300.0))
                .setTravelled(100)
                .setTariffDistance(BigDecimal.valueOf(20.0))
                .setTariffTime(BigDecimal.valueOf(100.0))
                .setTimeCount(LocalTime.parse("02:15:00"));
        travel.setPayment(payment);

        travelRepository.save(travel);
        Travel fromDB = travelRepository.getReferenceById(travelNumber);

        System.out.println(fromDB);

        Assertions.assertEquals(fromDB.getTravelNumber(), fromDB.getPayment().getTravelNumber());

    }
}
