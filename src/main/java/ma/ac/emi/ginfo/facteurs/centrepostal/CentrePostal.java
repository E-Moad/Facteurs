package ma.ac.emi.ginfo.facteurs.centrepostal;

import jakarta.persistence.*;
import ma.ac.emi.ginfo.facteurs.centreregional.CentreRegional;
import ma.ac.emi.ginfo.facteurs.colis.Colis;
import ma.ac.emi.ginfo.facteurs.facteur.Facteur;
import ma.ac.emi.ginfo.facteurs.habitant.Habitant;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CentrePostal {

    private String nom;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    private String rue;
    private String quartier;
    private String ville;
    @OneToMany(mappedBy = "centrePostal")
    private Collection<Facteur> facteurs;
    @OneToMany(mappedBy = "centrePostal")
    private Collection<Habitant> habitants;
    @ManyToOne
    private CentreRegional centreRegional;
    @ManyToMany
    private Collection<Colis> colis;

    public CentrePostal(String nom,
                        Integer numero,
                        String rue,
                        String quartier,
                        String ville,
                        Collection<Facteur> facteurs,
                        Collection<Habitant> habitants,
                        CentreRegional centreRegional,
                        Collection<Colis> colis) {
        this.nom = nom;
        this.numero = numero;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
        this.facteurs = facteurs;
        this.habitants = habitants;
        this.centreRegional = centreRegional;
        this.colis = colis;
    }

    public CentrePostal() {
    }

    public String getNom() {
        return nom;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getQuartier() {
        return quartier;
    }

    public String getVille() {
        return ville;
    }

    public Collection<Facteur> getFacteurs() {
        return facteurs;
    }

    public Collection<Habitant> getHabitants() {
        return habitants;
    }

    public CentreRegional getCentreRegional() {
        return centreRegional;
    }

    public Collection<Colis> getColis() {
        return colis;
    }

    @Override
    public String toString() {
        return "CentrePostal{" +
                "nom='" + nom + '\'' +
                ", numero=" + numero +
                ", rue='" + rue + '\'' +
                ", quartier='" + quartier + '\'' +
                ", ville='" + ville + '\'' +
                ", facteurs=" + facteurs +
                ", habitants=" + habitants +
                ", centreRegional=" + centreRegional +
                ", colis=" + colis +
                '}';
    }
}
