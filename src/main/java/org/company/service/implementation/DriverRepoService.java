package org.company.service.implementation;

import lombok.RequiredArgsConstructor;
import org.company.dao.entity.Driver;
import org.company.repository.DriverRepository;
import org.company.service.IDriverRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverRepoService implements IDriverRepoService {

    final DriverRepository driverRepository;

    @Override
    public boolean save(Driver entity) {
        Integer id = driverRepository.save(entity).getId();
        return driverRepository.existsById(id);
    }

    @Override
    public Driver findById(Integer id) {
        Optional<Driver> driver = driverRepository.findById(id);
        return driver
                .orElseThrow(() -> new RuntimeException(
                        "Не найден водитель с id " + id)
                );
    }

    @Override
    public boolean deleteById(Integer id) {
        driverRepository.deleteById(id);
        return !driverRepository.existsById(id);
    }
}
