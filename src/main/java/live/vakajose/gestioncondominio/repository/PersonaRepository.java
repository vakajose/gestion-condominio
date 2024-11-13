package live.vakajose.gestioncondominio.repository;

import live.vakajose.gestioncondominio.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String> {
}
