package cris.reservas.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import cris.reservas.api.model.Reserva;
import cris.reservas.api.service.ReservaService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtener(@PathVariable Long id) {
        return reservaService.obtenerReserva(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reserva crear(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.obtenerReserva(id).map(r -> {
            r.setFechaReserva(reserva.getFechaReserva());
            r.setHoraInicio(reserva.getHoraInicio());
            r.setHoraFin(reserva.getHoraFin());
            r.setUsuario(reserva.getUsuario());
            r.setSala(reserva.getSala());
            return ResponseEntity.ok(reservaService.guardarReserva(r));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }
}
