package pe.edu.idat.vetbackendmovil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.idat.vetbackendmovil.model.Mascota;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota,Long> {

    @Query("SELECT m FROM Mascota m WHERE m.usuario.idUsuario = :idUsuario")
    List<Mascota> findByUsuarioId(Long idUsuario);
}
