package ma.ac.emi.ginfo.facteurs.habitant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1/habitants")
@RestController
public class HabitantController {

    public final HabitantService habitantService;

    @Autowired
    public HabitantController(HabitantService habitantService) {
        this.habitantService = habitantService;
    }

    @PostMapping
    public Habitant addHabitant(@RequestBody Habitant habitant) {
        return habitantService.saveHabitant(habitant);
    }
}
