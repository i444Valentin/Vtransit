package org.company;

import org.company.dao.entity.Driver;
import org.company.dao.entity.License;
import org.company.repository.DriverRepository;
import org.company.repository.LicenseRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Данный класс выполняет последовательное тестирование
 * сохранения, получения, обновления и удаления записи из базы
 * данных.
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DriverRepositoryTest {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    LicenseRepository licenseRepository;

    //статические поля с сущностями и id

    private static Integer id;

    private static Driver driver;

    private static License license;

    private static Long licenseNumber;

    @BeforeAll
    public static void prepareData() {
        id = 0;
        license = new License()
                .setSerialNumber(7414293330L)
                .setGibddNumber("7772")
                .setRegion("Московская область")
                .setCategories(new String[]{"A", "B", "B1E", "C"});
        driver = new Driver()
                .setId(id)
                .setFirstName("Колеев")
                .setLastName("Алексей")
                .setSurname("Игнатьевич")
                .setBirthDate(LocalDate.parse("1992-11-19"))
                .setLicense(license)
                .setGender("мужской");
        licenseNumber = license.getSerialNumber();
    }

    @Test
    @Order(3)
    @Transactional
    public void getDriverById() {
        assertTrue(driverRepository.existsById(id));
        Driver driver = driverRepository.getReferenceById(id);
        String expectedFirstName = "Колеев";
        String actualFirstName = driver.getFirstName();
        Assertions.assertEquals(expectedFirstName, actualFirstName);
        System.out.println(driver);
    }

    @Test
    @Order(2)
    @Transactional
    public void getDriverByLicense() {
        Optional<Driver> drivers = driverRepository.findByLicense(licenseNumber);
        assertTrue(drivers.isPresent());
        String expectedFirstName = "Колеев";
        String actualFirstName = drivers.get().getFirstName();
        Assertions.assertEquals(expectedFirstName, actualFirstName);
        System.out.println(drivers);
    }

    @Test
    @Transactional
    @Order(1)
    @Commit
    public void saveNewDriverAndCheck() {
        License licenseIn = licenseRepository.save(license);
        Driver driver1 = driverRepository.save(driver);
        Driver gotDriver = driverRepository.getReferenceById(driver1.getId());
        assertNotNull(gotDriver);
        String expectedFirstName = "Колеев";
        String actualFirstName = gotDriver.getFirstName();
        Assertions.assertEquals(expectedFirstName, actualFirstName);
        System.out.println(gotDriver);
        driver = gotDriver;
        license = licenseIn;
        id = driver.getId();
    }

    @Test
    @Transactional
    @Order(4)
    @Commit
    public void updateDriverAndCheck() {
        License licenseIn = license;
        Driver driverIn = driver;
        license.setGibddNumber("8777")
                .setRegion("Астраханская область");
        driver.setFirstName("Рябова")
                .setGender("женский")
                .setLastName("Ольга")
                .setSurname("Яковлевна");
        licenseRepository.save(licenseIn);
        driverRepository.save(driverIn);
        Driver gotDriver = driverRepository.getReferenceById(driverIn.getId());
        assertNotNull(gotDriver);
        String expectedFirstName = "Рябова";
        String actualFirstName = gotDriver.getFirstName();
        Assertions.assertEquals(expectedFirstName, actualFirstName);
        System.out.println(gotDriver);
    }

    @Test
    @Transactional
    @Order(5)
    @Commit
    public void deleteDriverAndCheck() {
        Driver driver = driverRepository.getReferenceById(id);
        License license = licenseRepository.getReferenceById(id);
        licenseRepository.delete(license);
        driverRepository.delete(driver);
        Assertions.assertFalse(driverRepository.existsById(id));
        Assertions.assertFalse(licenseRepository.existsById(id));
    }

}
