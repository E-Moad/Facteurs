package ma.ac.emi.ginfo.facteurs.facteur;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ma.ac.emi.ginfo.facteurs.centrepostal.CentrePostal;
import ma.ac.emi.ginfo.facteurs.colis.Colis;
import ma.ac.emi.ginfo.facteurs.personne.Personne;

import java.util.Collection;

@Entity
public class Facteur extends Personne {
    @ManyToOne
    private CentrePostal centrePostal;
    @JsonIgnore()
    @OneToMany(mappedBy = "facteur")
    private Collection<Colis> colis;

    public Facteur(Long id, String nom, String prenom, String rue, String quartier, String ville, CentrePostal centrePostal, Collection<Colis> colis) {
        super(id, nom, prenom, rue, quartier, ville);
        this.centrePostal = centrePostal;
        this.colis = colis;
    }

    public Facteur() {
    }

    public CentrePostal getCentrePostal() {
        return centrePostal;
    }

    public Collection<Colis> getColis() {
        return colis;
    }

    @Override
    public String toString() {
        return "Facteur{" +
                "centrePostal=" + centrePostal +
                ", colis=" + colis +
                '}';
    }
}
