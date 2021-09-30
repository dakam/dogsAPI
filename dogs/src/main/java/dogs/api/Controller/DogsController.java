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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class DogsController {

    @Autowired
    DogsServiceInt dogsService;

    @GetMapping("/all")
    public Map<String, String> getAllBreeds() throws IOException, ParseException, JSONException {

        String str = dogsService.loadDogsBreeds();
        JSONObject br= new JSONObject(str );

        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();

        String s = br.toString().replace("\n", "");
         s = s.replace("\\", "");
         s= s.replaceAll(" ", "");
        s= s.replaceAll("\"", "");


        map.put("message", s);
        System.out.println("json="+map);
         return map;
    }
}
