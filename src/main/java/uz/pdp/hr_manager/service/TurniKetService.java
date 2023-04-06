package uz.pdp.hr_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.hr_manager.entity.TurniKet;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.repository.TurniKetRepo;

import java.util.List;

@Service
public class TurniKetService {

    @Autowired
    TurniKetRepo turniKetRepo;


    public List<TurniKet> turniKetList() {
        List<TurniKet> ketList = turniKetRepo.findAll();
        return ketList;
    }

    public Result addTurniKet(TurniKet turniKet) {
        TurniKet turniKet1 = new TurniKet();
        turniKet1.setEntry(turniKet.getEntry());
        turniKet1.setExit(turniKet.getExit());
        turniKetRepo.save(turniKet1);
        return new Result("Save", true);
    }

}
