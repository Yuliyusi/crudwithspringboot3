package umukozi.umukozibi.employe;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Mission {
    @Id
    @GeneratedValue
    private int id;
    private String descriptionMission;

    public Mission(int id, String descriptionMission) {
        this.id = id;
        this.descriptionMission = descriptionMission;
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
