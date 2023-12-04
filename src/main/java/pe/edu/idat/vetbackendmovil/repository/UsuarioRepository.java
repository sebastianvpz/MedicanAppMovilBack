package pe.edu.idat.vetbackendmovil.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.vetbackendmovil.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

}

