package grushevkaya.onboarding.neoflex.controller;

import grushevkaya.onboarding.neoflex.dto.VacationPayCalcInputTO;
import grushevkaya.onboarding.neoflex.dto.VacationPayOutputTO;
import grushevkaya.onboarding.neoflex.service.VacationPayCalcService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class VacationPayCalcController {
    private final VacationPayCalcService vacationPayCalcService;

    @Autowired
    public VacationPayCalcController(VacationPayCalcService vacationPayCalcService) {
        this.vacationPayCalcService = vacationPayCalcService;
    }

    @GetMapping(path = "/calculate")
    public VacationPayOutputTO calcVacation(@RequestBody @Valid VacationPayCalcInputTO vacationPayCalcInputTO) {
        VacationPayOutputTO result = vacationPayCalcService.calcVacation(vacationPayCalcInputTO);
        return result;
    }
}
