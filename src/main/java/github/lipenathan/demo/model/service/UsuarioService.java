package github.lipenathan.demo.model.service;


import github.lipenathan.demo.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private int id = 0;
    private List<Usuario> usuarios = new ArrayList<>();

    public boolean novoUsuario(Usuario usuario) throws Exception {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new Exception("O nome precisa ser preenchido");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("O e-mail precisa ser preenchido");
        }

        usuario.setId(++id);
        usuarios.add(usuario);
        return true;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Usuario> consultaUsuarios(String email, String nome) {
        List<Usuario> usuariosEncontrados;
        usuariosEncontrados = usuarios.stream().filter(usuario -> usuario.getEmail().contains(email) && usuario.getNome().contains(nome)).toList();
        return usuariosEncontrados;
    }

    public boolean apagarUsuario(int id) throws Exception {
        boolean deletou = usuarios.removeIf(usuario -> usuario.getId() == id);

        if (!deletou) {
            throw new Exception("Usuário com id " + id + " não encontrado");
        }

        return deletou;
    }

    public boolean atualizarUsuario(Usuario usuario) throws Exception {
        boolean atualizou = false;

        for (Usuario usuarioAux : usuarios) {
            if (usuarioAux.getId() == usuario.getId()) {
                usuarioAux.setNome(usuario.getNome());
                usuarioAux.setEmail(usuario.getEmail());
                usuarioAux.setSenha(usuario.getSenha());
                atualizou = true;
            }
        }

        if (!atualizou) {
            throw new Exception("Usuário com id " + id + " não encontrado");
        }

        return atualizou;
    }
}
