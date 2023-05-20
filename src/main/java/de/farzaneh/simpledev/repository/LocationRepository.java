package de.farzaneh.simpledev.repository;

import de.farzaneh.simpledev.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
