package baumer.one.stream.example.validation;

import baumer.one.stream.bean.CloseApproachData;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

public class ValidationExample {
    @Test
    public void noErrors(){
        CloseApproachData closeApproachData = CloseApproachData.builder()
                .close_approach_date(LocalDate.of(1991,01,01))
                .orbiting_body("Earth")
                .build();

        final CloseApproachDataValidation validation = CloseApproachDataValidation.empty
                .and(CloseApproachDataValidation.closeApproachDateAfter2000)
                .and(CloseApproachDataValidation.closeApproachDateBefore1950)
                .and(CloseApproachDataValidation.moonOrbitingBody);

        System.out.println(validation.apply(closeApproachData));
    }

    @Test
    public void oneError(){
        CloseApproachData closeApproachData = CloseApproachData.builder()
                .close_approach_date(LocalDate.of(2020,01,01))
                .orbiting_body("Earth")
                .build();

        final CloseApproachDataValidation validation = CloseApproachDataValidation.empty
                .and(CloseApproachDataValidation.closeApproachDateAfter2000)
                .and(CloseApproachDataValidation.closeApproachDateBefore1950)
                .and(CloseApproachDataValidation.moonOrbitingBody);

        System.out.println(validation.apply(closeApproachData));
    }

    @Test
    public void multipleErrors(){
        CloseApproachData closeApproachData = CloseApproachData.builder()
                .close_approach_date(LocalDate.of(2020,01,01))
                .orbiting_body("Moon")
                .build();

        final CloseApproachDataValidation validation = CloseApproachDataValidation.empty
                .and(CloseApproachDataValidation.closeApproachDateAfter2000)
                .and(CloseApproachDataValidation.closeApproachDateBefore1950)
                .and(CloseApproachDataValidation.moonOrbitingBody);

        System.out.println(validation.apply(closeApproachData));
    }

}
