package ma.ac.emi.ginfo.facteurs.centrepostal;

import ma.ac.emi.ginfo.facteurs.colis.Colis;
import ma.ac.emi.ginfo.facteurs.colis.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentrePostalService {
    @Autowired
    private CentrePostalRepository centrePostalRepository;
    @Autowired

    private ColisRepository colisRepository;
    CentrePostal saveCentrePostal(CentrePostal centrePostal) {
      return centrePostalRepository.save(centrePostal);
    };

    Colis saveColis(Colis colis) {
        return colisRepository.save(colis);
    };

    void addCentrePostaltoColis(String centrePostalNom, Long colisNumero) {
        Colis colis = colisRepository.findById(colisNumero).orElse(null);
        CentrePostal centrePostal = centrePostalRepository.findByNom(centrePostalNom);
        colis.getCentrePostalCollection().add(centrePostal);

    };



}
