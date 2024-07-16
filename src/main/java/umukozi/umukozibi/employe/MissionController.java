package umukozi.umukozibi.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/mission")
public class MissionController {
    private  final MissionService missionservice;

    @Autowired
    public MissionController(MissionService missionservice) {
        this.missionservice = missionservice;
    }
    @GetMapping
    public List<Mission> getMission(){
        return missionservice.getMission();
    }
    @GetMapping(path = "{MissionID}")
    public Optional<Mission> getMissionById(@PathVariable("MissionID") int MissionID){
        return missionservice.getMissionById(MissionID);
    }
    @PostMapping
    public Mission addMission(@RequestBody Mission mission){
        return missionservice.addMission(mission);
    }
    @PutMapping(path = "{missionId}")
    public Mission editMission(@RequestBody Mission mission,@PathVariable("missionId") int missionId){
      return missionservice.editMission(mission,missionId);
    }
    @DeleteMapping(path = "{missionId}")
    public void deletteMission(@PathVariable("missionId") int missionId){
        missionservice.deletteMission(missionId);
    }

}
