package pe.edu.idat.vetbackendmovil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.vetbackendmovil.model.Medico;
import pe.edu.idat.vetbackendmovil.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/{id}")
    public Medico obtenerMedicoPorId(@PathVariable Long id) {
        return medicoService.obtenerMedicoPorId(id);
    }
}
