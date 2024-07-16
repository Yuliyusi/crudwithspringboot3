package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/departement")
public class DepartementController {

    private final DepartementService departementService;

    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }
    @GetMapping
    public List<Departement> getDepatement(){
        return departementService.getDepatement();

    }
    @GetMapping(path = "{departementId}")
    public Optional<Departement> getDepartementById(@PathVariable("departementId") int departementId){
        return departementService.getDepartementById(departementId);
    }
    @PostMapping
    public Departement addDepartement(@RequestBody Departement departement){
        return departementService.addDepartement(departement) ;
    }
    @PutMapping(path = "{departementId}")
    public Departement editDepartement(@RequestBody Departement departement,@PathVariable("departementId") int departementId){
      return departementService.editDepartement(departement,departementId)  ;
    }
    @DeleteMapping(path = "{departementId}")
    public void supprimerDepartement(@PathVariable("departementId") int departementId){
       departementService.supprimerDepartement(departementId);
    }

}
