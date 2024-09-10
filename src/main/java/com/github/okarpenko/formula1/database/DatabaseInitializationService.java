package com.github.okarpenko.formula1.database;

import com.github.okarpenko.formula1.service.CircuitService;
import com.github.okarpenko.formula1.service.DriverService;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DatabaseInitializationService {

    private final Formula1HttpClient formula1HttpClient;
    private final CircuitService circuitService;
    private final DriverService driverService;


}
