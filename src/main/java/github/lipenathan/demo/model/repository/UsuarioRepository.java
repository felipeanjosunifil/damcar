package github.lipenathan.demo.model.repository;

import github.lipenathan.demo.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findAllByNome(String nome);
}
