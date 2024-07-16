package umukozi.umukozibi.employe;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Mission {
    @Id
    @GeneratedValue
    private int id;
    private String descriptionMission;
    @ManyToMany
    @JoinTable(name = "employe_mission",joinColumns = @JoinColumn(name = "mission_id"),inverseJoinColumns = @JoinColumn(name = "employe_id"))
    private Set<Employe> employes;
    public Mission(int id, String descriptionMission) {
        this.id = id;
        this.descriptionMission = descriptionMission;
    }

    public Mission() {
    }

    public Set<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Set<Employe> employes) {
        this.employes = employes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionMission() {
        return descriptionMission;
    }

    public void setDescriptionMission(String descriptionMission) {
        this.descriptionMission = descriptionMission;
    }
}
