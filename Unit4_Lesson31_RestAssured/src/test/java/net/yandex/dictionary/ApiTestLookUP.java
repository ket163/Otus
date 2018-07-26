package net.yandex.dictionary;

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ApiTestLookUP extends PrepareClass{



    @Test
    public void lookUpTest() {
                get(LOOKUP_URL + "?key=" + VALID_KEY + "&lang=en-ru&text=undefined")
                .then()
                .statusCode(200);

        String json = get(LOOKUP_URL + "?key=" + VALID_KEY + "&lang=en-ru&text=undefined").asString();
        List<String> text = JsonPath.read(json, "$..text");
        Assert.assertTrue(text.contains("неясный"));

    }

    @Test
    public void lookUpTestWithWrongLanguage() {

                get(LOOKUP_URL + "?key=" + VALID_KEY + "&lang=en-kz&text=undefined")
                .then()
                .statusCode(400)
                .body("code",equalTo(501))
                .body("message",equalTo("The specified language is not supported"));

    }





                                       //For debug
    // public static void main(String[] args) throws  UnirestException {
//       String responce =  Unirest.get(LOOKUP_URL + "?key=" + VALID_KEY + "&lang=en-ru&text=time").asString().getBody();
//        System.out.println(responce);

//        String json = Unirest.get(LOOKUP_URL + "?key=" + VALID_KEY + "&lang=en-ru&text=time").asString().getBody();
//       List<String> text = JsonPath.read(json, "$..text");
//       System.out.println(text);
//
// }

}


