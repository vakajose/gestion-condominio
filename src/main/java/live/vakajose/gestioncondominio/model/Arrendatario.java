package live.vakajose.gestioncondominio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
@Getter
@Setter
public class Arrendatario {
    @Id
    private String id;
    private String nombre;
    private String contacto;
    private List<Departamento> departamentos;
}
