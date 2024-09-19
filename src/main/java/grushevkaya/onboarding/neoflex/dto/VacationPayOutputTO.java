package grushevkaya.onboarding.neoflex.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
@Setter
public class VacationPayOutputTO {
    private Double calculatedVacationPay;
    private List<String> logs;

    public VacationPayOutputTO() {
        this.calculatedVacationPay = -1.0;
        this.logs = new ArrayList<>();
    }

    public void addLog(String log) {
        this.logs.add(log);
    }
}
