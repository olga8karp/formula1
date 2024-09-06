package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.entity.Circuit;
import com.github.okarpenko.formula1.entity.Driver;
import com.github.okarpenko.formula1.repository.DriverRepository;
import com.github.okarpenko.formula1.service.Formula1HttpClient.CircuitsResponse;
import com.github.okarpenko.formula1.service.Formula1HttpClient.DriverResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverService {

    private final Formula1HttpClient httpClient;
    private final DriverRepository driverRepository;

    public void saveAllDrivers(List<DriverResponse> driverResponseList) {
        List<Driver> drivers = driverResponseList.stream()
            .map(DriverService::mapDtoToEntity)
            .toList();
        driverRepository.saveAll(drivers);
    }

    public Page<Driver> findAll(Pageable pageable) {
        List<Driver> drivers = httpClient.getDrivers().stream()
            .map(DriverService::mapDtoToEntity)
            .toList();
        return new PageImpl<>(
            drivers,
            pageable,
            drivers.size()
        );
    }

    public Driver findById(Long id) {
        Formula1HttpClient.DriverResponse driverById = httpClient.getDriverById(id);
        return mapDtoToEntity(driverById);
    }

    private static Driver mapDtoToEntity(Formula1HttpClient.DriverResponse cr) {
        Driver driver = new Driver();
        driver.setId(cr.getId());
        driver.setName(cr.getName());
        driver.setNumber(cr.getNumber());
        driver.setNationality(cr.getNationality());
        return driver;
    }
}
