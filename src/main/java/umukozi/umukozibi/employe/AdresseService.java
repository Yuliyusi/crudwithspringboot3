package umukozi.umukozibi.employe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService {
    private final AdresseRepository adresseRepository;
    @Autowired
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }
    public  Adresse addAdresse(Adresse adresse) {
     return adresseRepository.save(adresse);
    }
    public List<Adresse> getAllAdresse() {
        return adresseRepository.findAll();
    }
    public Adresse updateAdresse(int id,Adresse adresse) {
        if (!this.isExisteAdresse(id)){
            throw new  IllegalStateException("L'adresse de id "+ id +" n'existe pas");
        }
        adresse.setId(id);
        return adresseRepository.save(adresse);
    }
    public void deleteAdresse(int adresseId) {
        if (!this.isExisteAdresse(adresseId)){
            throw new  IllegalStateException("L'adresse de id  "+ adresseId +" n'existe pas");
        }
        adresseRepository.deleteById(adresseId);
    }
    public Optional<Adresse> getAdresseById(int adresseId) {
        return adresseRepository.findById(adresseId);
    }
    public boolean isExisteAdresse(int adresseId){
        return adresseRepository.existsById(adresseId);
    }

}
