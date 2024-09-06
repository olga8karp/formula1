package com.github.okarpenko.formula1.database;

import com.github.okarpenko.formula1.service.CircuitService;
import com.github.okarpenko.formula1.service.Formula1HttpClient;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DatabaseInitializationService {

    private final Formula1HttpClient formula1HttpClient;
    private final CircuitService circuitService;

    @PostConstruct
    public void initialize() {
        circuitService.saveAllCircuits(formula1HttpClient.getCircuits());

    }

}
