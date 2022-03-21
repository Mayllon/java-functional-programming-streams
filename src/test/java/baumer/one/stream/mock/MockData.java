package baumer.one.stream.mock;

import baumer.one.stream.bean.NearEarthObject;
import baumer.one.stream.config.LocalDateSerializer;
import baumer.one.stream.config.LocalDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import com.google.common.io.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static List<NearEarthObject> getNearEarthObjects() throws IOException {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        InputStream inputStream = Resources.getResource("neo.json").openStream();;
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<NearEarthObject>>(){}.getType();

        return gson.fromJson(json,listType);
    }
}
