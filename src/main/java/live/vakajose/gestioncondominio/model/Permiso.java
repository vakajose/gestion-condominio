package live.vakajose.gestioncondominio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "permisos")
public class Permiso {
    @Id
    private String id; // Ej. "CREAR_CONDOMINIO"
    private String nombre;
    private String descripcion;

    // Getters y setters
}

