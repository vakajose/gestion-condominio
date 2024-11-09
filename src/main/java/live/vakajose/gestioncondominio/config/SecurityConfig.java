package live.vakajose.gestioncondominio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Desactiva CSRF de forma actualizada para simplificar pruebas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/graphql").permitAll()  // Permitir acceso público a /graphql
                        .anyRequest().authenticated()  // Requiere autenticación para otras rutas
                )
                .httpBasic(Customizer.withDefaults());  // Permite autenticación básica (opcional para pruebas)
        return http.build();
    }
}
