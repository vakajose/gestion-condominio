package live.vakajose.gestioncondominio.repository;

import live.vakajose.gestioncondominio.model.Condominio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominioRepository extends MongoRepository<Condominio, String> {
}