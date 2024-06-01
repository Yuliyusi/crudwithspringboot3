package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            throw  new IllegalStateException("L'employe "+EmployeId+"n'existe pas");
        }
        employeRepository.deleteById(EmployeId);
    }
}
