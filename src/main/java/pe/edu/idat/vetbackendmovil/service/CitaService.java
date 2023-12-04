package pe.edu.idat.vetbackendmovil.service;

import pe.edu.idat.vetbackendmovil.model.Cita;

public interface CitaService {
    Cita obtenerCitaPorId(Long id);
    Cita crearCita(Cita cita);
}
