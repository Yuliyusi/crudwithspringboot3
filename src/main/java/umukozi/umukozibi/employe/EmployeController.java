package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employes")
public class EmployeController {
    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getEmploye(){
        return employeService.getEmploye();
    }
    @PostMapping
    public void AddNewEmployer(@RequestBody Employe employe){
        employeService.AddNewEmploye(employe);
    }
    @PutMapping
    public void updateEmploye(@RequestBody Employe employe){
        employeService.updateEmploye(employe);

    }
    @DeleteMapping(path = "{EmployeId}")
    public void deleteEmploye(@PathVariable("EmployeId") Long EmployeId){
        employeService.deleteEmploye(EmployeId);
    }
}
