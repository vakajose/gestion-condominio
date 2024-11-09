package live.vakajose.gestioncondominio.service;

import live.vakajose.gestioncondominio.model.Condominio;
import live.vakajose.gestioncondominio.repository.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondominioService {

    private final CondominioRepository condominioRepository;

    @Autowired
    public CondominioService(CondominioRepository condominioRepository) {
        this.condominioRepository = condominioRepository;
    }

    public Condominio saveCondominio(Condominio condominio) {
        return condominioRepository.save(condominio);
    }

    public List<Condominio> getAllCondominios() {
        return condominioRepository.findAll();
    }
}
