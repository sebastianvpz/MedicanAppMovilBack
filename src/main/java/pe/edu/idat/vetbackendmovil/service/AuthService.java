package pe.edu.idat.vetbackendmovil.service;

import pe.edu.idat.vetbackendmovil.dto.LoginRequestDTO;
import pe.edu.idat.vetbackendmovil.dto.UsuarioDTO;
import pe.edu.idat.vetbackendmovil.model.Usuario;

public interface AuthService {

    boolean autenticarUsuario(LoginRequestDTO loginRequest);
    Long obtenerIdUsuarioPorEmail(String email);

}
