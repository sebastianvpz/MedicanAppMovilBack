package pe.edu.idat.vetbackendmovil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.vetbackendmovil.model.Mascota;
import pe.edu.idat.vetbackendmovil.model.Usuario;
import pe.edu.idat.vetbackendmovil.dto.MascotaDTO;
import pe.edu.idat.vetbackendmovil.repository.MascotaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    @Autowired
    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public MascotaDTO obtenerMascotaPorId(Long id) {
        Mascota mascota = mascotaRepository.findById(id).orElse(null);
        return convertirAMascotaDTO(mascota);
    }

    @Override
    public MascotaDTO registrarMascota(MascotaDTO mascotaDTO) {
        Mascota mascota = convertirAMascotaEntity(mascotaDTO);
        mascota = mascotaRepository.save(mascota);
        return convertirAMascotaDTO(mascota);
    }

    @Override
    public List<MascotaDTO> obtenerMascotasPorIdUsuario(Long idUsuario) {
        List<Mascota> mascotas = mascotaRepository.findByUsuarioId(idUsuario);
        return mascotas.stream()
                .map(this::convertirAMascotaDTO)
                .collect(Collectors.toList());
    }

    // Métodos adicionales según sea necesario para convertir entre entidades y DTOs

    private MascotaDTO convertirAMascotaDTO(Mascota mascota) {
        // Lógica para convertir de Mascota a MascotaDTO
        // Puedes usar librerías como ModelMapper o hacerlo manualmente
        // Ejemplo manual:
        MascotaDTO mascotaDTO = new MascotaDTO();
        mascotaDTO.setIdMascota(mascota.getIdMascota());
        mascotaDTO.setNombre(mascota.getNombre());
        // Otros campos
        return mascotaDTO;
    }

    private Mascota convertirAMascotaEntity(MascotaDTO mascotaDTO) {
        // Lógica para convertir de MascotaDTO a Mascota
        // Puedes usar librerías como ModelMapper o hacerlo manualmente
        // Ejemplo manual:
        Mascota mascota = new Mascota();
        mascota.setIdMascota(mascotaDTO.getIdMascota());
        mascota.setNombre(mascotaDTO.getNombre());
        // Otros campos
        return mascota;
    }
}
