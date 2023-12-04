package pe.edu.idat.vetbackendmovil.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long idUsuario;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int DNI;
    private int celular;
    private String email;
    private String contrasena;



    public UsuarioDTO(Long idUsuario, String nombres, String apellidos, String direccion, int DNI, int celular, String email,String contrasena) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.DNI = DNI;
        this.celular = celular;
        this.email = email;
        this.contrasena = contrasena;
    }


}
