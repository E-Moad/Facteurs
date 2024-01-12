package ma.ac.emi.ginfo.facteurs.facteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacteurService {

    private final FacteurRepository facteurRepository;

    @Autowired
    public FacteurService(FacteurRepository facteurRepository) {
        this.facteurRepository = facteurRepository;
    }

    public Facteur findById(Long id) {
        return facteurRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Facteur pas trouvé"));
    }

    Facteur saveFacteur(Facteur facteur) {
        return facteurRepository.save(facteur);
    }
}
