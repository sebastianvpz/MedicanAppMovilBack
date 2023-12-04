package pe.edu.idat.vetbackendmovil.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String apellido;
    private int dni;
    private String direccion;
    private int celular;
    private String email;
    private String contrasena;

    @OneToMany(mappedBy = "usuario")
    private List<Mascota> mascotas;

    public boolean autenticar(String email, String contrasena) {
        return this.email.equals(email) && this.contrasena.equals(contrasena);
    }




}
