package com.josemurillo.missiontrack.custodian;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustodianRepository
        extends JpaRepository<Custodian, Long> {
}
