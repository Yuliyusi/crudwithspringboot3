package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;

    }

    public List<Employe> getEmploye(){
        return employeRepository.findAll();
    }

    public void AddNewEmploye(Employe employe) {
        //System.out.println(employe);
        Optional<Employe> employeByEmail= employeRepository.findEmployeByEmail(employe.getEmail());
        if (employeByEmail.isPresent()){
            throw new IllegalStateException("Email must be unique");
        }
        employeRepository.save(employe);
    }

    public void deleteEmploye(Long EmployeId) {
        boolean existid= employeRepository.existsById(EmployeId);
        if (!existid){
            throw  new IllegalStateException("L'employe "+EmployeId+" n'existe pas");
        }
        employeRepository.deleteById(EmployeId);
    }
  /*  $2y$10$5sZ9tAeNoRku/BYUuSsJWOa.ZfhmLFZMgz40Ny0UVZQc.sUij06L2*/
    public void updateEmploye(Employe employe) {
        boolean employeFounded=false;
        for(Employe currentEmploye: this.getEmploye() ){
            if (currentEmploye.getId() == employe.getId()){
                employeFounded=true;
                currentEmploye.setEmail(employe.getEmail());
                currentEmploye.setNom(employe.getNom());
                currentEmploye.setPrenom(employe.getPrenom());
                currentEmploye.setDateNaissaince(employe.getDateNaissaince());
                currentEmploye.setTelephone(employe.getTelephone());
            }
            if (employeFounded){
                employeRepository.save(currentEmploye);
            }else {
                throw new IllegalStateException("L'employe "+employe.getId()+" n'existe pas");
            }
        }
    }

    public Optional<Employe> getEmployeById(Long employeId) {
        return employeRepository.findById(employeId);
    }
}
