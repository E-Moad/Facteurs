package ma.ac.emi.ginfo.facteurs.colis;

import jakarta.persistence.*;
import ma.ac.emi.ginfo.facteurs.centrepostal.CentrePostal;
import ma.ac.emi.ginfo.facteurs.facteur.Facteur;
import ma.ac.emi.ginfo.facteurs.habitant.Habitant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

@Entity
public class Colis {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @Temporal(TemporalType.DATE)
    private Date dateDepot;
    @Temporal(TemporalType.DATE)
    private Date dateReception;
    @ManyToMany(mappedBy = "colis")
    private Collection<CentrePostal> centrePostalCollection;
    @ManyToOne
    private Facteur facteur;
    @ManyToOne
    private Habitant emetteur;
    @ManyToOne
    private Habitant destinataire;

    public Colis(Long numero,
                 Date dateDepot,
                 Date dateReception,
                 Collection<CentrePostal> centrePostalCollection,
                 Facteur facteur,
                 Habitant emetteur,
                 Habitant destinataire) {
        this.numero = numero;
        this.dateDepot = dateDepot;
        this.dateReception = dateReception;
        this.centrePostalCollection = centrePostalCollection;
        this.facteur = facteur;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
    }

    public Colis() {
    }

    public Long getNumero() {
        return numero;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public Collection<CentrePostal> getCentrePostalCollection() {
        return centrePostalCollection;
    }

    public Facteur getFacteur() {
        return facteur;
    }

    public Long getFacteurId() {
        if(facteur != null) {
            return facteur.getId();
        }
        return null;
    }

    public Habitant getEmetteur() {
        return emetteur;
    }

    public Long getEmetteurId() {
        if(emetteur != null) {
            return emetteur.getId();
        }
        return null;
    }

    public Habitant getDestinataire() {
        return destinataire;
    }

    public Long getDestinataireId() {
        if(destinataire != null) {
            return destinataire.getId();
        }
        return null;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public void setFacteur(Facteur facteur) {
        this.facteur = facteur;
    }

    public void setEmetteur(Habitant emetteur) {
        this.emetteur = emetteur;
    }

    public void setDestinataire(Habitant destinataire) {
        this.destinataire = destinataire;
    }

    @Override
    public String toString() {
        return "Colis{" +
                "numero=" + numero +
                ", dateDepot=" + dateDepot +
                ", dateReception=" + dateReception +
                ", centrePostalCollection=" + centrePostalCollection +
                ", facteur=" + facteur +
                ", emetteur=" + emetteur +
                ", destinataire=" + destinataire +
                '}';
    }
}
