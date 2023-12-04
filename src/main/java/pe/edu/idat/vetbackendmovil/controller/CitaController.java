package pe.edu.idat.vetbackendmovil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.vetbackendmovil.model.Cita;
import pe.edu.idat.vetbackendmovil.service.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/{id}")
    public Cita obtenerCitaPorId(@PathVariable Long id) {
        return citaService.obtenerCitaPorId(id);
    }

    @PostMapping("/crear")
    public Cita crearCita(@RequestBody Cita cita) {
        return citaService.crearCita(cita);
    }

    // Puedes agregar otros endpoints según sea necesario
}
