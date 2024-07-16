package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private final MissionRepository missionrepository;
    @Autowired
    public MissionService(MissionRepository missionrepository) {
        this.missionrepository = missionrepository;
    }

    public List<Mission> getMission() {
        return missionrepository.findAll();
    }

    public Optional<Mission> getMissionById(int missionID) {
        return missionrepository.findById(missionID);
    }

    public Mission addMission(Mission mission) {
        return missionrepository.save(mission);
    }

    public void deletteMission(int missionId) {
        if (this.findMission(missionId)){
        missionrepository.deleteById(missionId);}else {
            throw new IllegalStateException("Le mission avec id "+missionId+" n'existe pas");
        }
    }

    public Mission editMission(Mission mission, int missionId) {
        if (this.findMission(missionId)){
        mission.setId(missionId);
        return missionrepository.save(mission);
        }else {
            throw new IllegalStateException("Le mission avec id "+missionId+" n'existe pas");
        }
    }
    public boolean findMission(int missionId){
        return missionrepository.existsById(missionId);
    }
}
