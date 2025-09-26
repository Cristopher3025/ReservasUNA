package cris.reservas.api.repo;

import cris.reservas.api.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepo extends JpaRepository<Sala, Long> {
}
