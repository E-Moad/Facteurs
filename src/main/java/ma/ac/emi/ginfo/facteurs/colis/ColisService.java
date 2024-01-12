package ma.ac.emi.ginfo.facteurs.colis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColisService {
    private final ColisRepository colisRepository;

    @Autowired
    public ColisService(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    List<Colis> getColis() {
      return colisRepository.findAll();
    }

    Colis getColis(Long numero) {
        return colisRepository
                .findById(numero)
                .orElseThrow(
                        () -> new RuntimeException("Colis pas trouvé")
                );
    }

    Colis saveColis(Colis colis) {return colisRepository.save(colis);}

    void deleteColis(Long id) {
        colisRepository.deleteById(id);
    }

    void deleteColisAll() {
        colisRepository.deleteAll();
    }
}
