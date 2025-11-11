package github.lipenathan.demo.model.service;

import github.lipenathan.demo.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private int id = 0;
    private List<Usuario> usuarios = new ArrayList<>();

    public boolean novoUsuario(Usuario usuario) throws Exception {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new Exception("O nome do usuário é obrigatório.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("O e-mail do usuário é obrigatório.");
        }

        usuario.setId(++id);
        usuarios.add(usuario);

        return true;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Usuario> consultarUsuarios(String nome, String email) {
        List<Usuario> usuariosEncontrados;

        usuariosEncontrados = usuarios.stream().filter(usuario -> usuario.getNome().contains(nome)).toList();

        return usuariosEncontrados;
    }

    public Boolean editarUsuario(Usuario usuario) throws Exception {

        boolean atualizarUsuario = false;
        int index = 0;

        for (Usuario usuarioAux: usuarios) {

            if (!atualizarUsuario) {
                index++;
            }
            if (usuarioAux.getId() == usuario.getId()) {
                atualizarUsuario = true;
            }
        }

        if (atualizarUsuario) {
            usuarios.set(index - 1, usuario);
            return true;
        } else {
            throw new Exception("Usuário com id " + usuario.getId() + " não foi encontrado.");
        }
    }

    public boolean deletarUsuario(int id) throws Exception {
        boolean deletarUsuario = false;
        int index = 0;

        for (Usuario usuarioAux: usuarios) {

            if (!deletarUsuario) {
                index++;
            }
            if (usuarioAux.getId() == id) {
                deletarUsuario = true;
            }
        }

        if (deletarUsuario) {
            usuarios.remove(index - 1);
            return true;
        } else {
            throw new Exception("Usuário com id " + id + " não foi encontrado.");
        }
    }

}
