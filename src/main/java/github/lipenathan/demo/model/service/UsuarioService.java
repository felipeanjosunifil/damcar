package github.lipenathan.demo.model.service;

import github.lipenathan.demo.model.Usuario;
import github.lipenathan.demo.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public boolean novoUsuario(Usuario usuario) {
        repository.save(usuario);
        return true;
    }

    public List<Usuario> getUsuarios() {
        Iterable<Usuario> usuarios = repository.findAll();

        return (List<Usuario>) usuarios;
    }

    public Usuario getUsuario(Long id) throws Exception {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isEmpty()) {
            throw new Exception("Usuário não encontrado");
        }

        return usuario.get();
    }
}
