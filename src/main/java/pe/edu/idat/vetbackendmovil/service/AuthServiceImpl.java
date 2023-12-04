package pe.edu.idat.vetbackendmovil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.idat.vetbackendmovil.dto.LoginRequestDTO;
import pe.edu.idat.vetbackendmovil.dto.UsuarioDTO;
import pe.edu.idat.vetbackendmovil.model.Usuario;
import pe.edu.idat.vetbackendmovil.repository.UsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public AuthServiceImpl(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean autenticarUsuario(LoginRequestDTO loginRequest) {
        // Obtén el usuario de la base de datos (puedes modificar el método según tu estructura)
        Usuario usuarioAlmacenado = usuarioRepository.findByEmail(loginRequest.getEmail());

        // Verifica las credenciales
        return usuarioAlmacenado != null && passwordEncoder.matches(loginRequest.getContrasena(), usuarioAlmacenado.getContrasena());
    }
    @Override
    public Long obtenerIdUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null ? usuario.getIdUsuario() : null;
    }
}
