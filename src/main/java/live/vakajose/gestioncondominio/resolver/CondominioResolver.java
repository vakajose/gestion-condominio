package live.vakajose.gestioncondominio.resolver;

import live.vakajose.gestioncondominio.model.Condominio;
import live.vakajose.gestioncondominio.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CondominioResolver {

    private final CondominioService condominioService;

    @Autowired
    public CondominioResolver(CondominioService condominioService) {
        this.condominioService = condominioService;
    }

    @QueryMapping
    public List<Condominio> condominios() {
        return condominioService.getAllCondominios();
    }

    @MutationMapping
    public Condominio registrarCondominio(@Argument String nombre,@Argument String direccion) {
        Condominio condominio = new Condominio();
        condominio.setNombre(nombre);
        condominio.setDireccion(direccion);
        return condominioService.saveCondominio(condominio);
    }
}
