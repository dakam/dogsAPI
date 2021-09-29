package dogs.api.Service;

import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class DogsService implements  DogsServiceInt {

    @Override
    public String loadDogsBreeds() throws IOException, ParseException {

        File resource = new ClassPathResource("apidata.json").getFile();
        String text = new String(Files.readAllBytes(resource.toPath()));


      return text;

    }
}
