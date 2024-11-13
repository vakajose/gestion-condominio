package live.vakajose.gestioncondominio.auth;

import live.vakajose.gestioncondominio.config.JwtTokenUtil;
import live.vakajose.gestioncondominio.model.Persona;
import live.vakajose.gestioncondominio.model.Usuario;
import live.vakajose.gestioncondominio.repository.PersonaRepository;
import live.vakajose.gestioncondominio.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private PersonaRepository  personaRepository;


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String token = jwtTokenUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        var user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singletonList(request.getRol().getId()))
                .build();

        var persona = Persona
                .builder()
                .ci(request.getCi())
                .nombre(request.getNombre())
                .build();
        personaRepository.save(persona);
        var jwtToken = jwtTokenUtil.generateToken(user.getUsername());
        //var refreshToken = jwtService.generateRefreshToken(user);
        //saveUserToken(savedUser, jwtToken);
        return ResponseEntity.ok(
                AuthenticationResponse.builder()
                        .accessToken(jwtToken)
                        //.refreshToken(refreshToken)
                        .build()
        );
    }

}