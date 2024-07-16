package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employes")
public class EmployeController {
    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public ResponseEntity getEmploye(){
            Map<String, Object> data = new HashMap<>();
            data.put("status", "200");
            data.put("message", "Success");
            data.put("data", employeService.getEmploye());
            data.put("next", "");
         return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity AddNewEmployer(@RequestBody EmployeDTO employeDTO){
        Map<String, Object> data = new HashMap<>();
        data.put("status", "200");
        data.put("message", "Success");
        data.put("data",employeService.AddNewEmploye(employeDTO));
        data.put("next", "");
        return  new ResponseEntity<>(data,HttpStatus.OK);
        //return ;
    }
    @PostMapping(path ="/assign-mission/{missionId}")
    public Employe addAndAssignEmployer(@RequestBody Employe employe,@PathVariable("missionId") int missionId){
        return employeService.addAndAssignEmployer(employe,missionId);
    }
    @PutMapping(path = "{EmployeId}")
    public Employe updateEmploye(@RequestBody EmployeDTO employeDTO,@PathVariable("EmployeId") long EmployeId){
        return employeService.updateEmploye(employeDTO,EmployeId);
   }

    @DeleteMapping(path = "{EmployeId}")
    public void deleteEmploye(@PathVariable("EmployeId") Long EmployeId){
        employeService.deleteEmploye(EmployeId);
    }

    @GetMapping(path = "{EmployeId}")
    public Optional<Employe> getEmployeById(@PathVariable("EmployeId") Long EmployeId){
        return employeService.getEmployeById(EmployeId);
    }
}
