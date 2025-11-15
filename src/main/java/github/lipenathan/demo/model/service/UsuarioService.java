package github.lipenathan.demo.model.service;

import github.lipenathan.demo.model.entity.Usuario;
import github.lipenathan.demo.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean atualizarUsuario(Usuario usuario) throws Exception {

        try {
            repository.save(usuario);
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar usuário:\n" + e.getMessage());
        }
    }

    public boolean deletarUsuario(Long id) throws Exception {

        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar usuario:\n" + e.getMessage());
        }
    }
}
