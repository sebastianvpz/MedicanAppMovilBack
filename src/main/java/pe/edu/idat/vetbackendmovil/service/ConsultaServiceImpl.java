package pe.edu.idat.vetbackendmovil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.vetbackendmovil.dto.ConsultaDTO;
import pe.edu.idat.vetbackendmovil.model.Consulta;
import pe.edu.idat.vetbackendmovil.repository.ConsultaRepository;

import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public ConsultaDTO obtenerConsultaDTO(Long id) {
        // Implementa la lógica para convertir Consulta a ConsultaDTO según tus necesidades
        Consulta consulta = consultaRepository.findById(id).orElse(null);
        return convertirConsultaADTO(consulta);
    }

    // Implementa otros métodos según sea necesario

    private ConsultaDTO convertirConsultaADTO(Consulta consulta) {
        // Lógica para convertir Consulta a ConsultaDTO
        if (consulta == null) {
            return null;
        }

        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setIdConsulta(consulta.getIdConsulta());
        consultaDTO.setRazon(consulta.getRazon());
        // Otros campos
        consultaDTO.setDescripcion(consulta.getDescripcion());
        consultaDTO.setDiagnostico(consulta.getDiagnostico());
        consultaDTO.setServicio(consulta.getServicio());
        consultaDTO.setFecha(consulta.getFecha());

        return consultaDTO;
    }

    @Override
    public List<Consulta> obtenerConsultasPorIdMascota(Long idMascota) {
        // Este método te permite obtener todas las consultas asociadas a una mascota específica
        return consultaRepository.findByMascota_IdMascota(idMascota);
    }
}
