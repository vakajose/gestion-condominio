package live.vakajose.gestioncondominio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "condominios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Condominio {
    @Id
    @Indexed(unique = true)
    private String id;
    private String nombre;
    private String direccion;
    private List<Modulo> modulos;
    private List<Parametro> parametros;
    private List<Persona> regentes;
    // getters y setters
}
