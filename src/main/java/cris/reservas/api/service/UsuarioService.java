package cris.reservas.api.service;

import cris.reservas.api.model.Usuario;
import cris.reservas.api.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repo;

    public List<Usuario> listarUsuarios() {
        return repo.findAll();
    }

    public Usuario guardarUsuario(Usuario u) {
        return repo.save(u);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminarUsuario(Long id) {
        repo.deleteById(id);
    }
}