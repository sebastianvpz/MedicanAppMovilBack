package pe.edu.idat.vetbackendmovil.dto;

import lombok.Data;
import pe.edu.idat.vetbackendmovil.model.Servicio;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {

    private Long idConsulta;
    private String razon;
    private String descripcion;
    private String diagnostico;
    private Servicio servicio;
    private LocalDateTime fecha;

    public ConsultaDTO(Long idConsulta, String razon, String descripcion, String diagnostico, Servicio servicio, LocalDateTime fecha) {
        this.idConsulta = idConsulta;
        this.razon = razon;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
        this.servicio = servicio;
        this.fecha = fecha;
    }

    public ConsultaDTO() {

    }
}
