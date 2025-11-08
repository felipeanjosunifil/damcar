package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.Usuario;
import github.lipenathan.demo.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

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

    @PutMapping("/atualizar")
    public ResponseEntity<?> aualizarUsuario(@RequestBody Usuario usuario) {

        try {
            usuarioService.atualizarUsuario(usuario);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Ocorreu um erro:\n" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable("id") int id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Ocorreu um erro:\n" + e.getMessage());
        }
    }
}
