package live.vakajose.gestioncondominio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class Departamento {
    @Id
    private String id;
    private String numero;
    private String tipo;
    private Persona propietario;
    private Persona arrendatario;
    private List<Persona> vivientes;
    private List<Expensa> expensas;
    // getters y setters
}
