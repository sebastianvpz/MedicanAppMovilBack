package pe.edu.idat.vetbackendmovil.dto;

import lombok.Data;

@Data
public class MascotaDTO {
    private Long idMascota;
    private String nombre;
    private String especie;
    private String sexo;
    private int edad;



}
