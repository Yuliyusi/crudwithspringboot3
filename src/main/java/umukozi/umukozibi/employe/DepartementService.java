package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {
    private final DepartementRepository departementRepository;
    @Autowired
    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getDepatement() {
        return departementRepository.findAll();
    }

    public Optional<Departement> getDepartementById(int departementId) {
        return departementRepository.findById(departementId);
    }

    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }
    public boolean isExistDepartement(int departementId){
        return  departementRepository.existsById(departementId);
    }

    public Departement editDepartement(Departement departement, int departementId) {
        if (this.isExistDepartement(departementId)){
            departement.setId(departementId);
            return departementRepository.save(departement);

        }else{
            throw new IllegalStateException("Le departement n'existe pas");
        }

    }

    public void supprimerDepartement(int departementId) {
        if (this.isExistDepartement(departementId)){
             departementRepository.deleteById(departementId);
        }else{
            throw new IllegalStateException("Le departement n'existe pas");

        }
    }
}
