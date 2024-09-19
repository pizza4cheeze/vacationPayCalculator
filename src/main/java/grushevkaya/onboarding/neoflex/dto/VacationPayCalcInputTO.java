package grushevkaya.onboarding.neoflex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacationPayCalcInputTO {
    @NonNull
    @Positive
    private Double averageSalary;
    private Integer vacationDays;
    private LocalDate vacationStartDate;
    private LocalDate vacationEndDate;
}
