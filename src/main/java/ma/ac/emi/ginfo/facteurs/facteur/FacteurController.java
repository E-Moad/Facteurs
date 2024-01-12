package ma.ac.emi.ginfo.facteurs.facteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1/facteurs")
@RestController
public class FacteurController {

    public final FacteurService facteurService;

    @Autowired
    public FacteurController(FacteurService facteurService) {
        this.facteurService = facteurService;
    }

    @PostMapping
    public Facteur addFacteur(@RequestBody Facteur facteur) {
        return facteurService.saveFacteur(facteur);
    }
}
