package github.lipenathan.demo.model.repository;

import github.lipenathan.demo.model.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    //select * from usuarios where nome = ...
    List<Usuario> findByNome(String nome);
}
