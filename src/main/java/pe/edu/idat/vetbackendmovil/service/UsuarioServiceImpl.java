package pe.edu.idat.vetbackendmovil.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.idat.vetbackendmovil.dto.UsuarioDTO;
import pe.edu.idat.vetbackendmovil.model.Usuario;
import pe.edu.idat.vetbackendmovil.repository.UsuarioRepository;
import pe.edu.idat.vetbackendmovil.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsuarioDTO obtenerUsuarioDTO(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return convertirAUsuarioDTO(usuario);
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario nuevoUsuario = convertirAUsuario(usuarioDTO);
        // Encriptar la contraseña antes de guardarla
        nuevoUsuario.setContrasena(passwordEncoder.encode(usuarioDTO.getContrasena()));
        // Implementa la lógica necesaria para la creación del usuario en el repositorio
        Usuario usuarioCreado = usuarioRepository.save(nuevoUsuario);
        return convertirAUsuarioDTO(usuarioCreado);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        if (usuarioExistente != null) {
            // Actualiza los campos del usuarioExistente con los valores de usuarioDTO
            usuarioExistente.setNombre(usuarioDTO.getNombres());
            usuarioExistente.setApellido(usuarioDTO.getApellidos());
            usuarioExistente.setDireccion(usuarioDTO.getDireccion());
            usuarioExistente.setDni(usuarioDTO.getDNI());
            usuarioExistente.setCelular(usuarioDTO.getCelular());
            usuarioExistente.setEmail(usuarioDTO.getEmail());

            // Implementa la lógica necesaria para la actualización del usuario en el repositorio
            Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
            return convertirAUsuarioDTO(usuarioActualizado);
        } else {
            // Manejo de usuario no encontrado
            return null;
        }
    }

    // Métodos de conversión entre Usuario y UsuarioDTO
    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        if (usuario != null) {
            return new UsuarioDTO(
                    usuario.getIdUsuario(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getDireccion(),
                    usuario.getDni(),
                    usuario.getCelular(),
                    usuario.getEmail(),
                    usuario.getContrasena()
            );
        } else {
            return null;
        }
    }

    private Usuario convertirAUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombres());
        usuario.setApellido(usuarioDTO.getApellidos());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setDni(usuarioDTO.getDNI());
        usuario.setCelular(usuarioDTO.getCelular());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setContrasena(usuarioDTO.getContrasena());
        return usuario;
    }
}
