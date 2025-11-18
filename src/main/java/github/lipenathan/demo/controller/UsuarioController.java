package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.entities.Usuario;
import github.lipenathan.demo.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/novo")
    public ResponseEntity<?> novoUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.novoUsuario(usuario);
            return ResponseEntity.status(201).body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<Usuario>> consultarUsuarios(@RequestParam("nome") String nome) {
        List<Usuario> usuariosEncontrados = usuarioService.consultarUsuarios(nome);
        return ResponseEntity.ok(usuariosEncontrados);
    }


    @PutMapping("/editar")
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario) {

        try {
            boolean atualizou = usuarioService.editarUsuario(usuario);
            return ResponseEntity.ok(atualizou);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable("id") Long id) {
        try {
            boolean deletou = usuarioService.deletarUsuario(id);
            return ResponseEntity.ok(deletou);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
