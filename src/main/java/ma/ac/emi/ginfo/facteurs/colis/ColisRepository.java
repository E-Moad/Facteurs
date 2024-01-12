package ma.ac.emi.ginfo.facteurs.colis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {
}
