package com.josemurillo.missiontrack.custodian;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/custodians")
public class CustodianController {

    private final CustodianService custodianService;

    public CustodianController(CustodianService custodianService) {
        this.custodianService = custodianService;
    }

    @PostMapping
    public ResponseEntity<Custodian> createCustodian(
            @RequestBody Custodian custodian) {

        Custodian createdCustodian =
                custodianService.createCustodian(custodian);

        return ResponseEntity.ok(createdCustodian);
    }

    @GetMapping
    public ResponseEntity<List<Custodian>> getAllCustodians() {

        return ResponseEntity.ok(
                custodianService.getAllCustodians()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Custodian> getCustodianById(
            @PathVariable Long id) {

        Optional<Custodian> custodian =
                custodianService.getCustodianById(id);

        if (custodian.isPresent()) {
            return ResponseEntity.ok(custodian.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
