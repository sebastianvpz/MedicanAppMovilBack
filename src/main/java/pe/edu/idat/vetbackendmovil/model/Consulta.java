package pe.edu.idat.vetbackendmovil.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    private String razon;
    private String descripcion;
    private String diagnostico;

    private LocalDateTime fecha;

    // Relación con Servicio
    @ManyToOne
    private Servicio servicio;

    // Relación con Mascota
    @ManyToOne
    @JsonIgnore
    private Mascota mascota;
}
