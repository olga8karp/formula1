package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.entity.details.DriverDetails;
import com.github.okarpenko.formula1.repository.DriverDetailsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DriverDetailsService {

    private final DriverDetailsRepository driverDetailsRepository;

    public DriverDetails addDriverDetails(DriverDetails driverDetails) {
        return driverDetailsRepository.save(driverDetails);
    }

    public List<DriverDetails> listDriverDetails(){
        return driverDetailsRepository.findAll();
    }

    public DriverDetails retrieveDriverDetailsByLastName(String lastName) {
        return driverDetailsRepository.findDriverDetailsByLastName(lastName);
    }

}
