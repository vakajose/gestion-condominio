package live.vakajose.gestioncondominio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class Modulo {
    @Id
    private String id;
    private String nombre;
    private int cantidadDepartamentos;
    private String tipoModulo;
    private List<String> areasSociales;
    private List<Departamento> departamentos;
    // getters y setters
}
