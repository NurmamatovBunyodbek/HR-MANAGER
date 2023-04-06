package uz.pdp.hr_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hr_manager.entity.TurniKet;
import uz.pdp.hr_manager.payload.Result;
import uz.pdp.hr_manager.service.TurniKetService;

import java.util.List;

@RestController
@RequestMapping("/turniket")
public class TurniKetController {

    @Autowired
    TurniKetService turniKetService;

    @GetMapping
    public List<TurniKet> all() {
        List<TurniKet> turniKets = turniKetService.turniKetList();
        return turniKets;
    }

    @PostMapping
    public Result add(@RequestBody TurniKet turniKet) {
        Result result = turniKetService.addTurniKet(turniKet);
        return result;
    }

}
