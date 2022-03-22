package baumer.one.stream.example.streams;

import baumer.one.stream.bean.NearEarthObject;
import baumer.one.stream.dto.NearEarthObjectFirstObservation;
import baumer.one.stream.mock.MockData;
import jdk.jfr.Description;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class Parsing {
    @Test
    @Description("Parsing list of object to list of String")
    public void objectToString() throws IOException {
        List<NearEarthObject> neos = MockData.getNearEarthObjects();
        List<String> nearEarthObjectFirstObservation = neos.stream()
                .map(NearEarthObject::getName)
                .peek(name -> System.out.println(name))
                .toList();
    }
    @Test
    @Description("Parsing list of object to DTO")
    public void objectToDTO() throws IOException {
        List<NearEarthObject> neos = MockData.getNearEarthObjects();
        Function<NearEarthObject,NearEarthObjectFirstObservation> neoToNeoFirstObservation = neo -> new NearEarthObjectFirstObservation(neo.getName(), neo.getOrbital_data().getFirst_observation_date());
        List<NearEarthObjectFirstObservation> nearEarthObjectFirstObservation = neos.stream()
                .map(neoToNeoFirstObservation)
                .peek(name -> System.out.println(name))
                .toList();
    }
}
