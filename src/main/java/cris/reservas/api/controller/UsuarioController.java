package cris.reservas.api.controller;

import cris.reservas.api.model.Usuario;
import cris.reservas.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500") // habilita acceso desde tu frontend
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET -> listar todos
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    // POST -> crear usuario
    @PostMapping
    public Usuario crear(@RequestBody Usuario u) {
        return usuarioService.guardarUsuario(u);
    }

    // DELETE -> eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    // PUT -> actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioDetalles.getNombre());
                    usuario.setCarrera(usuarioDetalles.getCarrera());
                    usuario.setCorreo(usuarioDetalles.getCorreo());
                    Usuario actualizado = usuarioService.guardarUsuario(usuario);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


