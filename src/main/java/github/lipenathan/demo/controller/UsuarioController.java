package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.Usuario;
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

    @GetMapping("/consulta")
    public ResponseEntity<List<Usuario>> consultaUsuarios(@RequestParam("email") String email, @RequestParam("nome") String nome) {
        List<Usuario> usuariosEncontrados;

        usuariosEncontrados = usuarios.stream().filter(usuario -> usuario.getEmail().contains(email) && usuario.getNome().contains(nome)).toList();

        return ResponseEntity.ok(usuariosEncontrados);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Boolean> apagarUsuario(@PathVariable("id") int id) {
        boolean deletou = usuarios.removeIf(usuario -> usuario.getId() == id);
        return ResponseEntity.ok(deletou);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Boolean> atualizarUsuario(@RequestBody Usuario usuario) {
        boolean atualizou = false;

        for (Usuario usuarioAux : usuarios) {
            if (usuarioAux.getId() == usuario.getId()) {
                usuarioAux.setNome(usuario.getNome());
                usuarioAux.setEmail(usuario.getEmail());
                usuarioAux.setSenha(usuario.getSenha());
                atualizou = true;
            }
        }

        return ResponseEntity.ok(atualizou);
    }
}