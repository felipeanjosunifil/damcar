package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.entity.Usuario;
import github.lipenathan.demo.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")//funciona como um prefixo para os endpoints desta classe
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/novo")
    public ResponseEntity<Boolean> novoUsuario(@RequestBody Usuario usuario) {
        usuarioService.novoUsuario(usuario);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.getUsuario(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
