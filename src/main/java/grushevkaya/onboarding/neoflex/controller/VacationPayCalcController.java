package grushevkaya.onboarding.neoflex.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import grushevkaya.onboarding.neoflex.dto.VacationPayCalcInputTO;
import grushevkaya.onboarding.neoflex.service.VacationPayCalcService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping(path = "")
public class VacationPayCalcController {
    private final VacationPayCalcService vacationPayCalcService;

    @Autowired
    public VacationPayCalcController(VacationPayCalcService vacationPayCalcService) {
        this.vacationPayCalcService = vacationPayCalcService;
    }

    @GetMapping(path = "/calc-vacation-pay")
    public String calcVacation(@RequestBody @Valid VacationPayCalcInputTO vacationPayCalcInputTO) throws IOException {
        return vacationPayCalcService.calcVacation(vacationPayCalcInputTO);
    }
}
