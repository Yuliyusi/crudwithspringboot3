package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/adresse")

public class AdresseController {
    private final AdresseService adresseService ;

    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @PostMapping
    public Adresse addAdesee(@RequestBody Adresse adresse){
       return  adresseService.addAdresse(adresse);
    }

    @GetMapping
    public List<Adresse> getAllAdresse(){
        return adresseService.getAllAdresse();
    }
    @GetMapping(path = "{adresseId}")
    public Optional<Adresse> getAdresseById(@PathVariable("adresseId") int adresseId){
        return adresseService.getAdresseById(adresseId);
    }

    @PutMapping(path = "{adresseId}")
    public Adresse updateAdresse(@PathVariable("adresseId") int adresseId,@RequestBody Adresse adresse){
        return adresseService.updateAdresse(adresseId,adresse);
    }
    @DeleteMapping(path = "{adresseId}")
    public void deleteAdresse(@PathVariable("adresseId") int adresseId){
        adresseService.deleteAdresse(adresseId);

    }



}
