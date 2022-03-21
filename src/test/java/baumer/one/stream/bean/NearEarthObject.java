package baumer.one.stream.bean;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NearEarthObject {
    private String id;
    private String neo_reference_id;
    private String name;
    private String name_limited;
    private int designation;
    private String nasa_jpl_url;
    private float absolute_magnitude_h;
    private EstimatedDiameter estimated_diameter;
    private boolean is_potentially_hazardous_asteroid;
    private List<CloseApproachData> close_approach_data;
    private OrbitalData orbital_data;

    public boolean isAfterThen(LocalDate localDate){
        return localDate.isBefore(orbital_data.getFirst_observation_date());
    }
}
