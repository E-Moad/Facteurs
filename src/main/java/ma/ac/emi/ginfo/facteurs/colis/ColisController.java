package ma.ac.emi.ginfo.facteurs.colis;

import com.zaxxer.hikari.util.ClockSource;
import ma.ac.emi.ginfo.facteurs.facteur.Facteur;
import ma.ac.emi.ginfo.facteurs.facteur.FacteurRepository;
import ma.ac.emi.ginfo.facteurs.facteur.FacteurService;
import ma.ac.emi.ginfo.facteurs.habitant.Habitant;
import ma.ac.emi.ginfo.facteurs.habitant.HabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping(path = "api/v1/colis")
@RestController
public class ColisController {

    private final ColisService colisService;
    private final FacteurService facteurService;
    private final HabitantService habitantService;


    @Autowired
    public ColisController(ColisService colisService,
                           FacteurService facteurService,
                           HabitantService habitantService) {
        this.colisService = colisService;
        this.facteurService = facteurService;
        this.habitantService = habitantService;
    }

    @GetMapping
    List<Colis> getColis() {return colisService.getColis();}

    @GetMapping(path = "/{colisId}")
    Colis getColis(@PathVariable("colisId") Long numero) {
        return colisService.getColis(numero);
    }

    @PostMapping(path = "/{facteurId}/{emetteurId}/{destinataireId}")
    public Colis createNewColis(@RequestBody Colis colis, @PathVariable("facteurId") Long facteurId, @PathVariable("emetteurId") Long emetteurId, @PathVariable("destinataireId") Long destinataireId) {
//        System.out.println("POST REQUEST");
//        System.out.println(colis);
        // Lookup related entities
        Facteur facteur = facteurService.findById(facteurId);

        Habitant emetteur = habitantService.findById(emetteurId);

        Habitant destinataire = habitantService.findById(destinataireId);


        // Set relations
        colis.setFacteur(facteur);
        colis.setEmetteur(emetteur);
        colis.setDestinataire(destinataire);

        // Validate dates
        if(colis.getDateDepot().after(colis.getDateReception())) {
            throw new RuntimeException("Invalid dates");
        }

        return colisService.saveColis(colis);
    }

    @DeleteMapping("/{id}")
    void deleteColis(@PathVariable Long id) {
        colisService.deleteColis(id);
    }

    @DeleteMapping
    void deleteColisAll() {
        colisService.deleteColisAll();
    }

}

