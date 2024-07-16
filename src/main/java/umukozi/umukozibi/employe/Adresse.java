package umukozi.umukozibi.employe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Adresse {

    @Id
    @GeneratedValue
    private int id;
    private String nomAdresse;
    private String zonePostale;
    @OneToMany(mappedBy = "adresse" )
    private List<Employe> employes;
    public Adresse(int id, String nomAdresse, String zonePostale) {
        this.id = id;
        this.nomAdresse = nomAdresse;
        this.zonePostale = zonePostale;
    }

    public Adresse() {
    }

    public Adresse(String nomAdresse, String zonePostale) {
        this.nomAdresse = nomAdresse;
        this.zonePostale = zonePostale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAdresse() {
        return nomAdresse;
    }

    public void setNomAdresse(String nomAdresse) {
        this.nomAdresse = nomAdresse;
    }

    public String getZonePostale() {
        return zonePostale;
    }

    public void setZonePostale(String zonePostale) {
        this.zonePostale = zonePostale;
    }

}
