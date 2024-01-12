package ma.ac.emi.ginfo.facteurs.facteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacteurRepository extends JpaRepository<Facteur, Long> {
}
