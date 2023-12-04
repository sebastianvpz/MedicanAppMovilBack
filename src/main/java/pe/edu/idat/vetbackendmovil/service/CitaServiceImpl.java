package pe.edu.idat.vetbackendmovil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.vetbackendmovil.model.Cita;
import pe.edu.idat.vetbackendmovil.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public Cita obtenerCitaPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public Cita crearCita(Cita cita) {
        // Puedes agregar lógica de validación aquí si es necesario
        return citaRepository.save(cita);
    }

    // Implementa otros métodos según sea necesario
}
