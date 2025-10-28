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
        return false;
    }
}
