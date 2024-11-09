package live.vakajose.gestioncondominio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Viviente {
    @Id
    private String id;
    private String nombre;
    private String contacto;
    private String relacion; //Relacion con el arrendatario o propietario
    private Departamento departamento;
}
