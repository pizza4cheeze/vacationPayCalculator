package grushevkaya.onboarding.neoflex.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class IsDayOffService {

    private final RestTemplate restTemplate;

    public IsDayOffService() {
        this.restTemplate = new RestTemplate();
    }

    public boolean checkIfDayOff(LocalDate date) {
        String dateString = date.toString();
        String url = "https://isdayoff.ru/" + dateString;
        String response = restTemplate.getForObject(url, String.class);

        return response != null && response.equals("0");
    }
}

