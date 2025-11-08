package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private int ID = 0;

    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/novo")
    public ResponseEntity<Boolean> novoUsuario(@RequestBody Usuario usuario) {

        usuario.setId(++ID);
        usuarios.add(usuario);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Boolean> aualizarUsuario(@RequestBody Usuario usuario) {

        boolean atualizado = false;

        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                atualizado = true;
                u.setNome(usuario.getNome());
                u.setEmail(usuario.getEmail());
                u.setSenha(usuario.getSenha());
            }
        }

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarUsuario(@PathVariable("id") int id) {
        int index = -1;
        int deletar = 0;
        boolean deletou;

        /* lógica mais complexa

        for (Usuario u : usuarios) {
            index++;
            if (u.getId() == id) {
                deletar = index;
            }
        }

        */

        deletou = usuarios.removeIf(u -> u.getId() == id); //lógica mais simples de deleção

        if (deletou) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
