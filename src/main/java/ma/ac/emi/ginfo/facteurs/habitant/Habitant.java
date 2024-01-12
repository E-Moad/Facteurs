package ma.ac.emi.ginfo.facteurs.habitant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import ma.ac.emi.ginfo.facteurs.centrepostal.CentrePostal;
import ma.ac.emi.ginfo.facteurs.colis.Colis;
import ma.ac.emi.ginfo.facteurs.personne.Personne;

import java.util.Collection;

@Entity
public class Habitant extends Personne {
    private String email;
    private String telephone;
    @ManyToOne
    private CentrePostal centrePostal;
    @JsonIgnore
    @OneToMany(mappedBy = "emetteur")
    private Collection<Colis> colisEmetteurCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "destinataire")
    private Collection<Colis> colisDestinataireCollection;

    public Habitant(Long id, String nom, String prenom, String rue, String quartier, String ville, String email, String telephone, CentrePostal centrePostal, Collection<Colis> colisEmetteurCollection, Collection<Colis> colisDestinataireCollection) {
        super(id, nom, prenom, rue, quartier, ville);
        this.email = email;
        this.telephone = telephone;
        this.centrePostal = centrePostal;
        this.colisEmetteurCollection = colisEmetteurCollection;
        this.colisDestinataireCollection = colisDestinataireCollection;
    }

    public Habitant() {
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public CentrePostal getCentrePostal() {
        return centrePostal;
    }

    public Collection<Colis> getColisEmetteurCollection() {
        return colisEmetteurCollection;
    }

    public Collection<Colis> getColisDestinataireCollection() {
        return colisDestinataireCollection;
    }

    @Override
    public String toString() {
        return "Habitant{" +
                "email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", centrePostal=" + centrePostal +
                ", colisEmetteurCollection=" + colisEmetteurCollection +
                ", colisDestinataireCollection=" + colisDestinataireCollection +
                '}';
    }
}
