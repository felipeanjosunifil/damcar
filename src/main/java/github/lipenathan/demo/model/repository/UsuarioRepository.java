package github.lipenathan.demo.model.repository;

import github.lipenathan.demo.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario searchByEmail(String email);
}
