package com.josemurillo.missiontrack.custodian;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustodianService {

    private final CustodianRepository custodianRepository;

    public CustodianService(CustodianRepository custodianRepository) {
        this.custodianRepository = custodianRepository;
    }

    public Custodian createCustodian(Custodian custodian) {
        return custodianRepository.save(custodian);
    }

    public List<Custodian> getAllCustodians() {
        return custodianRepository.findAll();
    }

    public Optional<Custodian> getCustodianById(Long id) {
        return custodianRepository.findById(id);
    }
}