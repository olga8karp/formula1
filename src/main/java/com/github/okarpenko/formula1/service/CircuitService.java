package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.entity.Circuit;
import com.github.okarpenko.formula1.repository.CircuitRepository;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.CircuitsResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CircuitService {

    private final Formula1HttpClient httpClient;
    private final CircuitRepository circuitRepository;

    public void saveAllCircuits(List<CircuitsResponse> circuitsResponseList){
        List<Circuit> circuits = circuitsResponseList.stream()
                .map(CircuitService::mapDtoToEntity)
                .toList();
        circuitRepository.saveAll(circuits);
    }

    public Page<Circuit> findAll(Pageable pageable) {
        List<Circuit> circuits = httpClient.getCircuits().stream()
                .map(CircuitService::mapDtoToEntity)
                .toList();
        return new PageImpl<>(
                circuits,
                pageable,
                circuits.size()
        );
    }

    public Circuit findById(Long id) {
        CircuitsResponse circuitById = httpClient.getCircuitById(id);
        return mapDtoToEntity(circuitById);
    }

    private static Circuit mapDtoToEntity(CircuitsResponse cr) {
        Circuit circuit = new Circuit();
        circuit.setId(cr.getId());
        circuit.setName(cr.getName());
        circuit.setImage(cr.getImage());
        return circuit;
    }

}
