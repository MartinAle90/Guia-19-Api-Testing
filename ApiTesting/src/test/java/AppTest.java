import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

public class AppTest {
    private String api;

    @BeforeClass
    public void setUp() {
        api = "https://swapi.dev/api/";
    }

    @Test
    public void getMethod() throws JsonProcessingException {
        Response response;
        response = given().get(api + "people/2/");

        ObjectMapper objectMapper = new ObjectMapper();
        PeoplePojo persona = objectMapper.readValue(response.asString(), PeoplePojo.class);


        String skinColor = persona.getSkin_color();
        int filmsCount = persona.getFilms().length;

        //otra forma sin usar Pojos
        /*JsonPath json = response.jsonPath();
        String skinColor = json.get("skin_color");
        int filmsCount = json.get("films.size()");*/

        System.out.println(skinColor + " - " + filmsCount + " " + persona.getEye_color());

        Assert.assertEquals("gold", skinColor);
        Assert.assertEquals(6, filmsCount);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test2() throws JsonProcessingException {
        Response response;
        Response responseFilm;
        response = given().get(api + "people/2/");

        ObjectMapper objectMapper = new ObjectMapper();
        PeoplePojo persona = objectMapper.readValue(response.asString(), PeoplePojo.class);

        String pelicula2 = persona.getFilms()[1];

        responseFilm = given().get(pelicula2);
        ObjectMapper objectMapperFilm = new ObjectMapper();
        FilmPojo film = objectMapperFilm.readValue(responseFilm.asString(), FilmPojo.class);


        Assert.assertTrue(film.getCharacters().length >= 1);
        Assert.assertTrue(film.getPlanets().length >= 1);
        Assert.assertTrue(film.getVehicles().length >= 1);
        Assert.assertTrue(film.getSpecies().length >= 1);

        Assert.assertTrue(film.getRelease_date().substring(4, 5).equals("-") &&
                film.getRelease_date().substring(7, 8).equals("-") &&
                Integer.parseInt(film.getRelease_date().substring(5, 7)) <= 12 &&
                Integer.parseInt(film.getRelease_date().substring(8, 9)) <= 31);

    }

    @Test
    public void test3() throws JsonProcessingException {
        Response response;
        Response responseFilm;
        response = given().get(api + "people/2/");

        ObjectMapper objectMapper = new ObjectMapper();
        PeoplePojo persona = objectMapper.readValue(response.asString(), PeoplePojo.class);

        String pelicula2 = persona.getFilms()[1];

        responseFilm = given().get(pelicula2);
        ObjectMapper objectMapperFilm = new ObjectMapper();
        FilmPojo film = objectMapperFilm.readValue(responseFilm.asString(), FilmPojo.class);


        Assert.assertTrue(film.getCharacters().length >= 1);
        Assert.assertTrue(film.getPlanets().length >= 1);
        Assert.assertTrue(film.getVehicles().length >= 1);
        Assert.assertTrue(film.getSpecies().length >= 1);

        Assert.assertTrue(film.getRelease_date().substring(4, 5).equals("-") &&
                film.getRelease_date().substring(7, 8).equals("-") &&
                Integer.parseInt(film.getRelease_date().substring(5, 7)) <= 12 &&
                Integer.parseInt(film.getRelease_date().substring(8, 9)) <= 31);

    }
}
