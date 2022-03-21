package baumer.one.stream.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NearEarthObjectFirstObservation {
    private String name;
    private LocalDate firstObservation;
}
