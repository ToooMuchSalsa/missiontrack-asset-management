package com.josemurillo.missiontrack.location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository
        extends JpaRepository<Location, Long> {

}
