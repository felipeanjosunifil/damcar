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

        boolean usuarioAtualizar = false;
        int index = 0;

        for (Usuario usuarioAux: usuarios) {

            if (!usuarioAtualizar) {
                index++;
            }
            if (usuarioAux.getId() == usuario.getId()) {
                usuarioAtualizar = true;
            }
        }

        if (usuarioAtualizar) {
            usuarios.set(index - 1, usuario);
            return true;
        } else {
            return false;
        }
    }
}
