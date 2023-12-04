package pe.edu.idat.vetbackendmovil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.vetbackendmovil.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
