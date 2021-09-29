package Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dogs.api.domain.Breed;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Service
public class DogsService implements  DogsServiceInt {


    @Value("classpath:apidata.json")
    public Resource resourceFile;


    @Override
    public String loadDogsBreeds() throws IOException, ParseException {
        
        File resource = new ClassPathResource("apidata.json").getFile();
        String text = new String(Files.readAllBytes(resource.toPath()));


      return text;

    }
}
