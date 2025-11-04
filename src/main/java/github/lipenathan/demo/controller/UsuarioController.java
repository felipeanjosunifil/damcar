package github.lipenathan.demo.controller;

import github.lipenathan.demo.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private int id = 0;
    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/novo")
    public ResponseEntity<Boolean> novoUsuario(@RequestBody Usuario usuario) {
        usuario.setId(++id);
        usuarios.add(usuario);

        return ResponseEntity.status(201).body(true);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/editar")
    public ResponseEntity<Boolean> editarUsuario(@RequestBody Usuario usuario) {

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
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarUsuario(@PathVariable("id") int id) {
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
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
