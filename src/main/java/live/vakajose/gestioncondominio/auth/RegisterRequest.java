package live.vakajose.gestioncondominio.auth;

import live.vakajose.gestioncondominio.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String nombre;
  private String ci;
  private String username;
  private String password;
  private Rol rol;
}
