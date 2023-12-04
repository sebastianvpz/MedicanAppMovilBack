package pe.edu.idat.vetbackendmovil.service;

import pe.edu.idat.vetbackendmovil.dto.UsuarioDTO;
import pe.edu.idat.vetbackendmovil.model.Usuario;


public interface UsuarioService {

    UsuarioDTO obtenerUsuarioDTO(Long id);
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO);
}
