package cris.reservas.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import cris.reservas.api.model.Sala;
import cris.reservas.api.service.SalaService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> listar() {
        return salaService.listarSalas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtener(@PathVariable Long id) {
        return salaService.obtenerSala(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sala crear(@RequestBody Sala sala) {
        return salaService.guardarSala(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizar(@PathVariable Long id, @RequestBody Sala sala) {
        return salaService.obtenerSala(id).map(s -> {
            s.setNombreSala(sala.getNombreSala());
            s.setEstado(sala.getEstado());
            return ResponseEntity.ok(salaService.guardarSala(s));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        salaService.eliminarSala(id);
        return ResponseEntity.noContent().build();
    }
}


