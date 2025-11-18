package github.lipenathan.demo.model.repository;

import github.lipenathan.demo.model.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepostory extends CrudRepository<Usuario, Long> {

    //select * from usuarios where nome = ...
    Iterable<Usuario> findByNome(String nome);
}
