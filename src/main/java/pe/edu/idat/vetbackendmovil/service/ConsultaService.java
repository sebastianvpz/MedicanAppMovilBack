package pe.edu.idat.vetbackendmovil.service;

import pe.edu.idat.vetbackendmovil.dto.ConsultaDTO;
import pe.edu.idat.vetbackendmovil.model.Consulta;

import java.util.List;

public interface ConsultaService {
    ConsultaDTO obtenerConsultaDTO(Long id);
    List<Consulta> obtenerConsultasPorIdMascota(Long idMascota);

}
