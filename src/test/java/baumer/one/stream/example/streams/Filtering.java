package baumer.one.stream.example.streams;

import baumer.one.stream.bean.NearEarthObject;
import baumer.one.stream.mock.MockData;
import jdk.jfr.Description;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Filtering {
    @Test
    @Description("Filtering by a String field")
    public void filterByAField() throws IOException {
        List<NearEarthObject> neos = MockData.getNearEarthObjects();
        Predicate<NearEarthObject> neosWith1991InTheName = neo -> neo.getName().contains("1991");
        neos.stream()
                .filter(neosWith1991InTheName)
                .map(NearEarthObject::getName)
                .forEach(System.out::println);
    }
    @Test
    @Description("Filtering by a LocalDate field")
    public void filterByAChildLocalDateField() throws IOException {
        LocalDate filterLocalDate = LocalDate.of(1990,01,01);
        List<NearEarthObject> neos = MockData.getNearEarthObjects();

        neos.stream()
                .filter(neo -> neo.isAfterThen(filterLocalDate))
                .peek(e -> System.out.println("Filtered value: " + e.getOrbital_data().getFirst_observation_date()))
                .map(NearEarthObject::getName)
                .forEach(System.out::println);
    }
}
