package dogs.api.Service;

import dogs.api.domain.Breed;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface DogsServiceInt {

    public String loadDogsBreeds() throws IOException, ParseException;
}
