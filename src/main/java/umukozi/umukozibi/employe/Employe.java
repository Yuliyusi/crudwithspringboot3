package umukozi.umukozibi.employe;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Employe {
    @Id
//    @SequenceGenerator(name="employe_sequence",sequenceName = "employe_seq",allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employe_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateNaissaince;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private  Adresse adresse;
    //Plusieurs employes peuvent travailler dans une meme departement
    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
    @ManyToMany
    @JoinTable(name = "employe_mission",joinColumns = @JoinColumn(name = "employe_id"),inverseJoinColumns = @JoinColumn(name = "mission_id"))
    private Set<Mission> missions;

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

    public Employe(String nom, String prenom, String email, String telephone, LocalDate dateNaissaince, Adresse adresse, Departement departement, Set<Mission> missions) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissaince = dateNaissaince;
        this.adresse = adresse;
        this.departement = departement;
        this.missions = missions;
    }

    public Employe(String nom, String prenom, String email, String telephone, LocalDate dateNaissaince, Adresse adresse, Departement departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissaince = dateNaissaince;
        this.adresse = adresse;
        this.departement = departement;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public Departement getDepartement() {
        return departement;
    }

    public Set<Mission> getMissions() {
        return missions;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }
    //helper function
    public void assignMission(Mission mission){
        missions.add(mission);

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
                ", adresse=" + adresse +
                ", departement=" + departement +
                ", missions=" + missions +
                '}';
    }
}
