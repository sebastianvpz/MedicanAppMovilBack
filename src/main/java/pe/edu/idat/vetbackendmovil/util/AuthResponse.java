package pe.edu.idat.vetbackendmovil.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private boolean autenticacionExitosa;
    private String mensaje;
    private Long idUsuario;
}
