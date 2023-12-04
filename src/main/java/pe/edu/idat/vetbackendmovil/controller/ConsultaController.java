package pe.edu.idat.vetbackendmovil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.vetbackendmovil.dto.ConsultaDTO;
import pe.edu.idat.vetbackendmovil.model.Consulta;
import pe.edu.idat.vetbackendmovil.service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/{id}")
    public ConsultaDTO obtenerConsultaDTO(@PathVariable Long id) {
        return consultaService.obtenerConsultaDTO(id);
    }

    @GetMapping("/mascota/{idMascota}")
    public List<Consulta> obtenerConsultasPorIdMascota(@PathVariable Long idMascota) {
        return consultaService.obtenerConsultasPorIdMascota(idMascota);
    }

}
