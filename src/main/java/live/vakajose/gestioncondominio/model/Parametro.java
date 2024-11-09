package live.vakajose.gestioncondominio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Parametro {
    @Id
    private String id;
    private String grupo;
    private String clave;
    private String valor;
}
