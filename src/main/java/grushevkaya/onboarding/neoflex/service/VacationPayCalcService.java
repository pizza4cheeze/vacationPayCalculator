package grushevkaya.onboarding.neoflex.service;

import grushevkaya.onboarding.neoflex.dto.VacationPayCalcInputTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VacationPayCalcService {
    private final IsDayOffService isDayOffService;
    private static final Integer workingDaysAverageAmount = 248;

    @Autowired
    public VacationPayCalcService(IsDayOffService isDayOffService) {
        this.isDayOffService = isDayOffService;
    }

    public String calcVacation(VacationPayCalcInputTO vacationPayCalcInputTO) throws IOException {
        Double result;
        if (vacationPayCalcInputTO.getVacationDays() != null) {
            result = ((double) vacationPayCalcInputTO.getVacationDays() / workingDaysAverageAmount) * vacationPayCalcInputTO.getAverageSalary();
        } else {
            // check for correctness of dates
            LocalDate startDate = vacationPayCalcInputTO.getVacationStartDate();
            LocalDate endDate = vacationPayCalcInputTO.getVacationEndDate();
            if (startDate.isAfter(endDate)) {
                throw new IOException("the start date of the vacation cannot be later than the end date of the vacation");
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
        }
        return String.valueOf(result);
    }
}
