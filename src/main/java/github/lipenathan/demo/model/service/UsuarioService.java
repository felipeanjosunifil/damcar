package github.lipenathan.demo.model.service;

import github.lipenathan.demo.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private int ID = 0;

    List<Usuario> usuarios = new ArrayList<>();

    public boolean novoUsuario(Usuario usuario) {
        usuario.setId(++ID);
        usuarios.add(usuario);
        return true;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean atualizarUsuario(Usuario usuario) throws Exception {

        boolean atualizado = false;

        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                atualizado = true;
                u.setNome(usuario.getNome());
                u.setEmail(usuario.getEmail());
                u.setSenha(usuario.getSenha());
            }
        }

        if (!atualizado) {
            throw new Exception("Usuário com id " + usuario.getId() + " não encontrado");
        }

        return atualizado;
    }

    public boolean deletarUsuario(int id) throws Exception {

        boolean deletou = usuarios.removeIf(u -> u.getId() == id); //lógica mais simples de deleção

        if (deletou) {
            return true;
        } else {
            throw new Exception("Usuário com id " + id + " não encontrado");
        }
    }
}
