package baumer.one.stream.example.validation;

import baumer.one.stream.bean.CloseApproachData;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface CloseApproachDataTrigger extends Predicate<CloseApproachData> {

    CloseApproachDataTrigger isCloseApproachDateAfter2000 = closeApproachData -> LocalDate.of(2000, 01, 01).isBefore(closeApproachData.getClose_approach_date());
    CloseApproachDataTrigger isCloseApproachDateBefore1950 = closeApproachData -> LocalDate.of(1950, 01, 01).isAfter(closeApproachData.getClose_approach_date());
    CloseApproachDataTrigger isMoonOrbitingBody = closeApproachData -> "Moon".equalsIgnoreCase(closeApproachData.getOrbiting_body());

    default CloseApproachDataTrigger or(final CloseApproachDataTrigger other) {
        return callAttributes -> this.test(callAttributes) || other.test(callAttributes);
    }
}
