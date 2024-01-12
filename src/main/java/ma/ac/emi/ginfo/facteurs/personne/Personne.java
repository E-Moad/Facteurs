package ma.ac.emi.ginfo.facteurs.personne;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String rue;
    private String quartier;
    private String ville;

    public Personne(Long id, String nom, String prenom, String rue, String quartier, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
    }

    public Personne() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", rue='" + rue + '\'' +
                ", quartier='" + quartier + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
