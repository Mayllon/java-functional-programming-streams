package baumer.one.stream.example.streams;

import baumer.one.stream.bean.CloseApproachData;
import baumer.one.stream.bean.NearEarthObject;
import baumer.one.stream.mock.MockData;
import jdk.jfr.Description;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Summarizing {
    @Test
    @Description("Print grouped child field and sum of same")
    public void printGroupedChildFieldAndSumOfSame() throws IOException {
        List<NearEarthObject> neos = MockData.getNearEarthObjects();
        neos.stream()
                .map(NearEarthObject::getClose_approach_data)
                .flatMap(x -> x.stream())
                .map(CloseApproachData::getOrbiting_body)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().forEach(e-> System.out.println(e));
    }
}
