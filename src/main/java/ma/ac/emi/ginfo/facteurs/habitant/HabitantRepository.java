package ma.ac.emi.ginfo.facteurs.habitant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitantRepository extends JpaRepository<Habitant, Long> {
}
