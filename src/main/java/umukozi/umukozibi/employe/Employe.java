package umukozi.umukozibi.employe;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Employe {
    @Id
    @SequenceGenerator(name="employe_sequence",sequenceName = "employe_name",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employe_sequence")
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateNaissaince;

    public Employe() {
    }

    public Employe(long id, String nom, String prenom, String email, String telephone, LocalDate dateNaissaince) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissaince = dateNaissaince;
    }

    public Employe(String nom, String prenom, String email, String telephone, LocalDate dateNaissaince) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissaince = dateNaissaince;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateNaissaince() {
        return dateNaissaince;
    }

    public void setDateNaissaince(LocalDate dateNaissaince) {
        this.dateNaissaince = dateNaissaince;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dateNaissaince=" + dateNaissaince +
                '}';
    }
}
