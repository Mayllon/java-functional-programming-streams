package baumer.one.stream.bean;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class CloseApproachData {
    private LocalDate close_approach_date;
    private LocalDateTime close_approach_date_full;
    private long epoch_date_close_approach;
    private RelativeVelocity relative_velocity;
    private MissDistance miss_distance;
    private String orbiting_body;
}
