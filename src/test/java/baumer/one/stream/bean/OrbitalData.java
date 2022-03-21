package baumer.one.stream.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrbitalData {
    private LocalDate first_observation_date;
    private LocalDate last_observation_date;
}
