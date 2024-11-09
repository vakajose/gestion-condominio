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
    private Propietario propietario;
    private Arrendatario arrendatario;
    private List<Viviente> vivientes;
    private List<Expensa> expensas;
    // getters y setters
}
