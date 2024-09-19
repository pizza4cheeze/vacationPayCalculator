package grushevkaya.onboarding.neoflex.service;

import grushevkaya.onboarding.neoflex.dto.VacationPayCalcInputTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacationPayCalcService {
    private final IsDayOffService isDayOffService;
    private static final Integer workingDaysAverageAmount = 248;

    @Autowired
    public VacationPayCalcService(IsDayOffService isDayOffService) {
        this.isDayOffService = isDayOffService;
    }

    public Double calcVacation(VacationPayCalcInputTO vacationPayCalcInputTO) {
        Double result = -1.0;

        if (vacationPayCalcInputTO.getVacationStartDate() != null && vacationPayCalcInputTO.getVacationEndDate() != null) {
            try {
                result = calcByDates(vacationPayCalcInputTO);
            } catch (BadRequestException e) {
                e.printStackTrace();
                result = calcByDaysAmount(vacationPayCalcInputTO);
            }
        } else if (vacationPayCalcInputTO.getVacationDays() != null) {
            result = calcByDaysAmount(vacationPayCalcInputTO);
        }
        return result;
    }

    private Double calcByDates(VacationPayCalcInputTO vacationPayCalcInputTO) throws BadRequestException {
        Double result;
        // check for correctness of dates
        LocalDate startDate = vacationPayCalcInputTO.getVacationStartDate();
        LocalDate endDate = vacationPayCalcInputTO.getVacationEndDate();
        if (startDate.isAfter(endDate)) {
            throw new BadRequestException("Start date cannot be after end date");
        }

        // creating dates list
        List<LocalDate> dates = new ArrayList<>();
        LocalDate currDate = startDate;
        while (currDate.isBefore(endDate)) {
            dates.add(currDate);
            currDate = currDate.plusDays(1);
        }

        // check dates for each
        Double payForDay = vacationPayCalcInputTO.getAverageSalary() / workingDaysAverageAmount;
        int totalDays = 0;
        for (LocalDate date : dates) {
            if (isDayOffService.checkIfDayOff(date)) totalDays++;
        }

        result = payForDay * totalDays;
        return result;
    }

    private static Double calcByDaysAmount(VacationPayCalcInputTO vacationPayCalcInputTO) {
        return ((double) vacationPayCalcInputTO.getVacationDays() / workingDaysAverageAmount) * vacationPayCalcInputTO.getAverageSalary();
    }
}
