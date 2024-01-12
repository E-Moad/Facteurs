package ma.ac.emi.ginfo.facteurs.centreregional;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import ma.ac.emi.ginfo.facteurs.centrepostal.CentrePostal;
import ma.ac.emi.ginfo.facteurs.colis.Colis;
import ma.ac.emi.ginfo.facteurs.facteur.Facteur;
import ma.ac.emi.ginfo.facteurs.habitant.Habitant;

import java.util.Collection;

@Entity
public class CentreRegional extends CentrePostal {
    @OneToMany(mappedBy = "centreRegional")
    private Collection<CentrePostal> centrePostalCollection;

    public CentreRegional(String nom, Integer numero, String rue, String quartier, String ville, Collection<Facteur> facteurs, Collection<Habitant> habitants, CentreRegional centreRegional, Collection<Colis> colis, Collection<CentrePostal> centrePostalCollection) {
        super(nom, numero, rue, quartier, ville, facteurs, habitants, centreRegional, colis);
        this.centrePostalCollection = centrePostalCollection;
    }

    public CentreRegional() {
    }

    public Collection<CentrePostal> getCentrePostalCollection() {
        return centrePostalCollection;
    }

    @Override
    public String toString() {
        return "CentreRegional{" +
                "centrePostalCollection=" + centrePostalCollection +
                '}';
    }
}
