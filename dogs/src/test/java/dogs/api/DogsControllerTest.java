package dogs.api;

import Service.DogsService;
import dogs.api.Controller.DogsController;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockito.Mockito.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DogsControllerTest {

    @Mock
    private DogsService dogsService;

    @InjectMocks
    private DogsController dogsController;


    public void setUp() throws IOException, ParseException {
        MockitoAnnotations.openMocks(this);



    }

    @Test
    public void DogsControllerTest() throws ParseException, JSONException, IOException {

        String breeds= "{\n" +
                "    \"wolfhound\": [\n" +
                "      \"irish\"\n" +
                "    ],\n" +
                "    \"whippet\": [],\n" +
                "    \"weimaraner\": [],\n" +
                "    \"waterdog\": [\n" +
                "      \"spanish\"\n" +
                "    ]}";
        when(dogsService.loadDogsBreeds()).thenReturn(breeds);
        String json = dogsController.getAllBreeds();
        Assert.assertEquals(json, breeds);
    }
}
