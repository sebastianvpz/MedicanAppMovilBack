package pe.edu.idat.vetbackendmovil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.vetbackendmovil.dto.MascotaDTO;
import pe.edu.idat.vetbackendmovil.model.Mascota;
import pe.edu.idat.vetbackendmovil.service.MascotaService;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> obtenerMascotaPorId(@PathVariable Long id) {
        MascotaDTO mascotaDTO = mascotaService.obtenerMascotaPorId(id);

        if (mascotaDTO != null) {
            return ResponseEntity.ok(mascotaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<MascotaDTO> registrarMascota(@RequestBody MascotaDTO mascotaDTO) {
        MascotaDTO nuevaMascotaDTO = mascotaService.registrarMascota(mascotaDTO);
        return ResponseEntity.ok(nuevaMascotaDTO);
    }


    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<MascotaDTO>> obtenerMascotasPorIdUsuario(@PathVariable Long idUsuario) {
        List<MascotaDTO> mascotasDTO = mascotaService.obtenerMascotasPorIdUsuario(idUsuario);

        if (!mascotasDTO.isEmpty()) {
            return ResponseEntity.ok(mascotasDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
