package cris.reservas.api.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import cris.reservas.api.model.Reserva;
import cris.reservas.api.repo.ReservaRepo;

@Service
public class ReservaService {

    private final ReservaRepo reservaRepo;

    public ReservaService(ReservaRepo reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    public List<Reserva> listarReservas() {
        return reservaRepo.findAll();
    }

    public Optional<Reserva> obtenerReserva(Long id) {
        return reservaRepo.findById(id);
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    public void eliminarReserva(Long id) {
        reservaRepo.deleteById(id);
    }
}
