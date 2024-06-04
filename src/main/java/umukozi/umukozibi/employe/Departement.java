package umukozi.umukozibi.employe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Departement {
    @Id
    @GeneratedValue
    private int id;
    private String description;

    //un departement peut avoir plusieurs employes
    @OneToMany(mappedBy = "departement" )
    private List<Employe> employes;

    public Departement(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
