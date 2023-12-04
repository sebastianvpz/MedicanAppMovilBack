package pe.edu.idat.vetbackendmovil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.vetbackendmovil.model.Consulta;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {

    List<Consulta> findByMascota_IdMascota(Long idMascota);
}
