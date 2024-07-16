package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private final EmployeRepository employeRepository;
    private final MissionRepository missionRepository;
    private final AdresseRepository adresseRepository;
    private final DepartementRepository departementRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository, MissionRepository missionRepository, AdresseRepository adresseRepository, DepartementRepository departementRepository) {
        this.employeRepository = employeRepository;
        this.missionRepository = missionRepository;
        this.adresseRepository = adresseRepository;
        this.departementRepository = departementRepository;
    }

    public List<Employe> getEmploye(){
        return  employeRepository.findAll();
    }

    public Employe AddNewEmploye(EmployeDTO employeDTO) {
        //System.out.println(employe);
        Optional<Employe> employeByEmail= employeRepository.findEmployeByEmail(employeDTO.getEmail());
        if (employeByEmail.isPresent()){
            throw new IllegalStateException("Email must be unique");
        }

        Employe employe = new Employe();
        employe.setNom(employeDTO.getNom());
        employe.setPrenom(employeDTO.getPrenom());
        employe.setEmail(employeDTO.getEmail());
        employe.setTelephone(employeDTO.getTelephone());
        employe.setDateNaissaince(employeDTO.getDateNaissaince());
        Departement departement = departementRepository.findById(employeDTO.getDepartement()).orElseThrow(()-> new RuntimeException("departement not found"));
        Adresse adresse = adresseRepository.findById(employeDTO.getAdresse()).orElseThrow(()-> new RuntimeException("adresse not found"));
        employe.setAdresse(adresse);
        employe.setDepartement(departement);

       return  employeRepository.save(employe);
    }

    public void deleteEmploye(Long EmployeId) {
        boolean existid= employeRepository.existsById(EmployeId);
        if (!existid){
            throw  new IllegalStateException("L'employe "+EmployeId+" n'existe pas");
        }
        employeRepository.deleteById(EmployeId);
    }
  /*  $2y$10$5sZ9tAeNoRku/BYUuSsJWOa.ZfhmLFZMgz40Ny0UVZQc.sUij06L2*/
    public Employe updateEmploye(EmployeDTO employeDTO,long employeId) {

        Employe currentEmploye = employeRepository.findById(employeId).orElseThrow(()->new RuntimeException("L'employe "+employeId+" n'existe pas"));
        currentEmploye.setEmail(employeDTO.getEmail());
        currentEmploye.setNom(employeDTO.getNom());
        currentEmploye.setPrenom(employeDTO.getPrenom());
        currentEmploye.setDateNaissaince(employeDTO.getDateNaissaince());
        currentEmploye.setTelephone(employeDTO.getTelephone());
        Departement departement = departementRepository.findById(employeDTO.getDepartement()).orElseThrow(()-> new RuntimeException("departement not found"));
        Adresse adresse = adresseRepository.findById(employeDTO.getAdresse()).orElseThrow(()-> new RuntimeException("adresse not found"));
        currentEmploye.setAdresse(adresse);
        currentEmploye.setDepartement(departement);
        return  employeRepository.save(currentEmploye);

    }

    public Optional<Employe> getEmployeById(Long employeId) {
        return employeRepository.findById(employeId);
    }

    public Employe addAndAssignEmployer(Employe employe, int missionId) {
        boolean isMissionExist= missionRepository.existsById(missionId);

        if (isMissionExist){
            return employe;

        }else{
            throw new IllegalStateException("La mission "+missionId+" n'existe pas");
        }
    }
}
