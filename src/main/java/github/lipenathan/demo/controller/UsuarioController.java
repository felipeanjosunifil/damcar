package github.lipenathan.demo.controller;

import github.lipenathan.demo.modelo.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    private int id = 0;
    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/usuarios/novo")
    public boolean novoUsuario(@RequestBody Usuario usuario) {
        usuario.setId(++id);
        usuarios.add(usuario);
        return true;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @PutMapping("/usuarios/editar")
    public boolean editarUsuario(@RequestBody Usuario usuario) {

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
            return false;
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public boolean deletarUsuario(@PathVariable("id") int id) {
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
            return false;
        }
    }
}
