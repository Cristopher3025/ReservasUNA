package cris.reservas.api.repo;

import cris.reservas.api.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Long> {
}
