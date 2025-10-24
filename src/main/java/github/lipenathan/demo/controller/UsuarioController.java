package github.lipenathan.demo.controller;

import github.lipenathan.demo.modelo.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @PostMapping("/usuarios/novo")
    public void novoUsuario(@RequestBody Usuario usuario) {
        System.out.println(usuario);
    }
}
