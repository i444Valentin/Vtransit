package org.company;

import org.company.dao.entity.Driver;
import org.company.repository.DriverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DriverRepositoryTest {

    @Autowired
    DriverRepository driverRepository;
    @Test
    public void getDriverById(){
        Driver driver = driverRepository.getReferenceById(3);
        assertNotNull(driver);
        String expectedFirstName = "Иванов";
        String actualFirstName = driver.getFirstName();
        Assertions.assertEquals(expectedFirstName,actualFirstName);
        System.out.println(driver);
    }
}
