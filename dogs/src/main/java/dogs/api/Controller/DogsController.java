package dogs.api.Controller;

import dogs.api.Service.DogsServiceInt;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class DogsController {

    @Autowired
    DogsServiceInt dogsService;

    @GetMapping("/all")
    public String getAllBreeds() throws IOException, ParseException, JSONException {
        
        String str = dogsService.loadDogsBreeds();
        JSONObject br= new JSONObject(str );
        System.out.println("json="+br);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
         return  str;
    }
}
