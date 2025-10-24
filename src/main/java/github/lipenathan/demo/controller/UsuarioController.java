package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")//funciona como um prefixo para os endpoints desta classe
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();
    private int ID = 0;

    @PostMapping("/novo")
    public boolean novoUsuario(@RequestBody Usuario usuario) {
        usuario.setId(++ID);
        usuarios.add(usuario);
        return true;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable int id) {
        Usuario usuario = null;

        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuario = u;
            }
        }

        return usuario;
    }
}
