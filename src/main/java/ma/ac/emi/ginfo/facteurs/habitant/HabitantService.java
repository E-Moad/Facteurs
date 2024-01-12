package ma.ac.emi.ginfo.facteurs.habitant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitantService {

    private final HabitantRepository habitantRepository;

    @Autowired
    public HabitantService(HabitantRepository habitantRepository) {
        this.habitantRepository = habitantRepository;
    }

    public Habitant findById(Long id) {
        return habitantRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Habitant pas trouvé")
                );
    }

    Habitant saveHabitant(Habitant habitant) {
        return habitantRepository.save(habitant);
    }
}
