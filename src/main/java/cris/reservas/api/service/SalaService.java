package cris.reservas.api.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import cris.reservas.api.model.Sala;
import cris.reservas.api.repo.SalaRepo;

@Service
public class SalaService {

    private final SalaRepo salaRepo;

    public SalaService(SalaRepo salaRepo) {
        this.salaRepo = salaRepo;
    }

    public List<Sala> listarSalas() {
        return salaRepo.findAll();
    }

    public Optional<Sala> obtenerSala(Long id) {
        return salaRepo.findById(id);
    }

    public Sala guardarSala(Sala sala) {
        return salaRepo.save(sala);
    }

    public void eliminarSala(Long id) {
        salaRepo.deleteById(id);
    }
}
