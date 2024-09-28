package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.entity.Driver;
import com.github.okarpenko.formula1.repository.DriverRepository;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.DriverResponse;
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

//    public void saveAllDrivers(List<DriverResponse> driverResponseList) {
//        List<Driver> drivers = driverResponseList.stream()
//            .map(DriverService::mapDtoToEntity)
//            .toList();
//        driverRepository.saveAll(drivers);
//    }
//
//    public Page<Driver> findAll(Pageable pageable) {
//        List<Driver> drivers = httpClient.getDrivers().stream()
//            .map(DriverService::mapDtoToEntity)
//            .toList();
//        return new PageImpl<>(
//            drivers,
//            pageable,
//            drivers.size()
//        );
//    }
//
    public Driver findByName(String name) {
       DriverResponse driverById = httpClient.getDriverByName(name);
        return mapDtoToEntity(driverById);
    }

    private static Driver mapDtoToEntity(DriverResponse cr) {
        Driver driver = new Driver();
        driver.setId(cr.getId());
        driver.setName(cr.getName());
        driver.setAbbr(cr.getAbbr());
        driver.setImage(cr.getImage());
        driver.setNationality(cr.getNationality());
        driver.setBirthdate(cr.getBirthdate());
        driver.setBirthplace(cr.getBirthplace());
        driver.setNumber(cr.getNumber());
        driver.setGrandsPrixEntered(cr.getGrands_prix_entered());
        driver.setWorldChampionships(cr.getWorld_championships());
        driver.setPodiums(cr.getPodiums());
        driver.setHighestGridPosition(cr.getHighest_grid_position());
        driver.setCareerPoints(cr.getCareer_points());
        driver.setTeams(cr.getTeams());
        return driver;
    }
}
