import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class StarWarsAPi {

    private String api;
    private PeoplePojo persona;

    @BeforeClass
    public void setUp() throws JsonProcessingException {
        api = "https://swapi.dev/api/";
        Response response1;
        response1 = given().get(api + "people/2");

        ObjectMapper objectMapper = new ObjectMapper();
        persona = objectMapper.readValue(response1.asString(), PeoplePojo.class);
    }

    @Test
    public void punto1() {

//        Response response1;
//        response1 = given().get(api+"people/2");
//        ObjectMapper objectMapper = new ObjectMapper();
//        people persona = objectMapper.readValue(response1.asString(), people.class);

        System.out.println(persona.getSkin_color() + " " + persona.getFilms().length);

        Assert.assertEquals(persona.getSkin_color(), "gold");
        Assert.assertEquals(persona.getFilms().length, 6);
    }

    @Test
    public void punto2() throws JsonProcessingException {

        Response response2;
        response2 = given().get(persona.getFilms()[1]);

        ObjectMapper objectMapper2 = new ObjectMapper();
        FilmPojo film;
        film = objectMapper2.readValue(response2.asString(), FilmPojo.class);

        System.out.println(film.getRelease_date());

        System.out.println(film.getRelease_date().substring(4,5));

        Assert.assertTrue(film.getRelease_date().substring(4, 5).equals("-") &&
                film.getRelease_date().substring(7, 8).equals("-") &&
                Integer.parseInt(film.getRelease_date().substring(5, 7)) <= 12 &&
                Integer.parseInt(film.getRelease_date().substring(8, 9)) <= 31);
        dele

    }

}
