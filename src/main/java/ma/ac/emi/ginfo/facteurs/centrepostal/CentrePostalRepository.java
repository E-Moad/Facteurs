package ma.ac.emi.ginfo.facteurs.centrepostal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CentrePostalRepository
        extends JpaRepository<CentrePostal, Integer> {

    CentrePostal findByNom(String nom);
}
