package pe.edu.idat.vetbackendmovil.service;

import pe.edu.idat.vetbackendmovil.dto.MascotaDTO;
import pe.edu.idat.vetbackendmovil.model.Mascota;

import java.util.List;

public interface MascotaService {
    MascotaDTO obtenerMascotaPorId(Long id);
    MascotaDTO registrarMascota(MascotaDTO  mascota);
    List<MascotaDTO> obtenerMascotasPorIdUsuario(Long idUsuario);
}