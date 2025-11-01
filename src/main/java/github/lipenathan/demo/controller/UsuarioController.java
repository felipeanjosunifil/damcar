package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    private int ID = 0;

    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/usuarios/novo")
    public boolean novoUsuario(@RequestBody Usuario usuario) {

        usuario.setId(++ID);
        usuarios.add(usuario);
        return true;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @PutMapping("/usuarios/atualizar")
    public boolean aualizarUsuario(@RequestBody Usuario usuario) {

        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                u.setNome(usuario.getNome());
                u.setEmail(usuario.getEmail());
                u.setSenha(usuario.getSenha());
            }
        }

        return true;
    }

    @DeleteMapping("/usuarios/{id}")
    public boolean deletarUsuario(@PathVariable("id") int id) {
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

        return deletou;
    }
}
