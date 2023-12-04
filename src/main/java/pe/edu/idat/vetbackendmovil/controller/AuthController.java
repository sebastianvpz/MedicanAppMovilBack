package pe.edu.idat.vetbackendmovil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.vetbackendmovil.dto.LoginRequestDTO;
import pe.edu.idat.vetbackendmovil.model.Usuario;
import pe.edu.idat.vetbackendmovil.service.AuthService;
import pe.edu.idat.vetbackendmovil.util.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequestDTO loginRequest) {
        boolean autenticacionExitosa = authService.autenticarUsuario(loginRequest);

        if (autenticacionExitosa) {
            Long idUsuario = authService.obtenerIdUsuarioPorEmail(loginRequest.getEmail());
            AuthResponse authResponse = new AuthResponse(true, "Autenticación exitosa", idUsuario);
            return ResponseEntity.ok(authResponse);
        } else {
            AuthResponse authResponse = new AuthResponse(false, "Autenticación fallida", null);
            return ResponseEntity.ok(authResponse);
        }
    }

    // Otros endpoints según sea necesario
}
