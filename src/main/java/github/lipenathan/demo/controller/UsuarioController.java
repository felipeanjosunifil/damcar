package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.Usuario;
import github.lipenathan.demo.model.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    @PostMapping("/novo")
    public ResponseEntity<?> novoUsuario(@RequestBody Usuario usuario) {

        try {
            usuarioService.novoUsuario(usuario);
            return ResponseEntity.status(201).body(true);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Ocorreu um erro:\n" + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<Usuario>> consultaUsuarios(@RequestParam("email") String email, @RequestParam("nome") String nome) {
        List<Usuario> usuariosEncontrados;

        usuariosEncontrados = usuarioService.consultaUsuarios(email, nome);

        return ResponseEntity.ok(usuariosEncontrados);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> apagarUsuario(@PathVariable("id") int id) {
        try {
            usuarioService.apagarUsuario(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody Usuario usuario) {

        try {
            usuarioService.atualizarUsuario(usuario);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}