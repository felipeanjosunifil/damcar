package github.lipenathan.demo.model.service;


import github.lipenathan.demo.model.entities.Usuario;
import github.lipenathan.demo.model.repository.UsuarioRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepostory usuarioRepostory;

    public boolean novoUsuario(Usuario usuario) throws Exception {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new Exception("O nome precisa ser preenchido");
        }

        usuarioRepostory.save(usuario);
        return true;
    }

    public List<Usuario> getUsuarios() {
        Iterable<Usuario> usuarios = usuarioRepostory.findAll();

        return (List<Usuario>) usuarios;
    }

    public List<Usuario> consultaUsuarios(String nome) {
        Iterable<Usuario> usuariosEncontrados = usuarioRepostory.findByNome(nome);

        return (List<Usuario>) usuariosEncontrados;
    }

    public boolean apagarUsuario(Long id) throws Exception {

        try {
            usuarioRepostory.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Usuário com id " + id + " não encontrado");
        }
    }

    public boolean atualizarUsuario(Usuario usuario) throws Exception {
        try {
            usuarioRepostory.save(usuario);
            return true;
        } catch (Exception e) {
            throw new Exception("Usuário com id " + usuario.getId() + " não encontrado");
        }
    }
}
