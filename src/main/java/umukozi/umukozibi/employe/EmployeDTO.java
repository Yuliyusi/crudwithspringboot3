package umukozi.umukozibi.employe;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

public class EmployeDTO {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateNaissaince;
    private Integer adresse;
    private Integer departement;
    private Set<String> missions;

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

    public Integer getAdresse() {
        return adresse;
    }

    public void setAdresse(Integer adresse) {
        this.adresse = adresse;
    }

    public Integer getDepartement() {
        return departement;
    }

    public void setDepartement(Integer departement) {
        this.departement = departement;
    }

    public Set<String> getMissions() {
        return missions;
    }

    public void setMissions(Set<String> missions) {
        this.missions = missions;
    }
}
