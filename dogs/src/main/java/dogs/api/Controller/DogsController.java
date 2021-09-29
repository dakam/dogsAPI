package dogs.api.Controller;

import Service.DogsService;
import Service.DogsServiceInt;
import dogs.api.domain.Breed;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class DogsController {



    @GetMapping("/all")
    public ResponseEntity<?> getAllBreeds() throws IOException, ParseException, JSONException {

        DogsService dogsService= new DogsService();


        String str = dogsService.loadDogsBreeds();
        JSONObject br= new JSONObject(str );
        System.out.println("json="+br);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
         return  new ResponseEntity<>(str, HttpStatus.OK);
    }
}
