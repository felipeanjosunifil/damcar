package github.lipenathan.demo.model.service;

import github.lipenathan.demo.model.entities.Usuario;
import github.lipenathan.demo.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean novoUsuario(Usuario usuario) throws Exception {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new Exception("O nome do usuário é obrigatório.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("O e-mail do usuário é obrigatório.");
        }

        usuarioRepository.save(usuario);

        return true;
    }

    public List<Usuario> getUsuarios() {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();

        return (List<Usuario>) usuarios;
    }

    public List<Usuario> consultarUsuarios(String nome) {
        List<Usuario> usuariosEncontrados = usuarioRepository.findByNome(nome);

        return usuariosEncontrados;
    }

    public Boolean editarUsuario(Usuario usuario) throws Exception {
        try {
            usuarioRepository.save(usuario);
            return true;
        } catch(Exception e) {
            throw new Exception("Ocorreu um erro " + e.getMessage());
        }
    }

    public boolean deletarUsuario(Long id) throws Exception {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro " + e.getMessage());
        }
    }
}

//create table(
