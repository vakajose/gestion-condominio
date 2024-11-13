package live.vakajose.gestioncondominio.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "personas")
public class Persona {
    @Id
    @Indexed(unique = true)
    private String id;
    private String nombre;
    @Indexed(unique = true)
    private String ci;
    private String contacto;
    private List<String> roles; // Ejemplo: ["PROPIETARIO", "ARRENDATARIO","VIVIENTE","REGENTE","ADMINISTRADOR"]

    private List<Departamento> departamentosPropietario; // Departamentos donde es propietario

    private List<Departamento> departamentosArrendatario; // Departamentos donde es arrendatario

    private Departamento departamentoViviente; // Departamento donde es viviente
    private String relacionViviente; //Relacion viviente INQUILINO/HUESPED/VIVIENTE

    private List<Condominio> condominiosRegente; // Condominios donde es regente
}
