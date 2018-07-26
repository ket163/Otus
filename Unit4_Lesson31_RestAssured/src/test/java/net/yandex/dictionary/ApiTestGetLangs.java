package net.yandex.dictionary;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ApiTestGetLangs extends PrepareClass {


    @Test
    public void dictTestWithValidKey() {
                 get(GETLANGS_URL + "?key=" + VALID_KEY)
                .then()
                .statusCode(200)
                .body("." , hasItems("ru-en","de-tr"));
     }

     @Test
    public void dictTestWithInvalidKey() {
                get(GETLANGS_URL + "?key=" + INVALID_KEY)
                .then()
                .statusCode(403)
                .body("message", equalTo("API key is invalid"))
                .body("code",equalTo(401));


    }

    @Test
    public void dictTestWuthBlockedKey() {
                get(GETLANGS_URL + "?key=" + BLOCKED_KEY)
                .then()
                .statusCode(403)
                .body("message", equalTo("API key is blocked"))
                .body("code",equalTo(402));


    }


                                           //For debug
//    public static void main(String[] args) throws UnirestException {
//       String responce =  Unirest.get(GETLANGS_URL + "?key=" + BLOCKED_KEY).asString().getBody();
//        System.out.println(responce);
//
//    }
}




