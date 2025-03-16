package steps;

import api.models.ApiResponse;
import api.models.Pet;
import api.models.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ReqresSteps {

    @Step("Отправить запрос GET https://petstore.swagger.io/v2/pet/(id)")
    public static ApiResponse getPetIdUnSuccess(String id) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("v2/pet/%s", id))
                .then()
                .spec(SpecHelper.getResponseSpec(404))
                .extract().body().jsonPath().getObject("", ApiResponse.class);
    }

    @Step("Отправить запрос GET https://petstore.swagger.io/v2/user/(username)")
    public static User getUserSuccess(String username) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("v2/user/%s", username))
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().body().jsonPath().getObject("", User.class);
    }

    @Step("Отправить запрос GET https://petstore.swagger.io/v2/user/(username)")
    public static User getUserUnSuccess(String username) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("v2/user/%s", username))
                .then()
                .spec(SpecHelper.getResponseSpec(404))
                .extract().body().jsonPath().getObject("", User.class);
    }

    @Step("Отправить запрос GET https://petstore.swagger.io/v2/pet/(id)")
    public static Pet getPetIdSuccess(String id) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("v2/pet/%s", id))
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().body().jsonPath().getObject("", Pet.class);
    }

    @Step("Отправить запрос POST https://petstore.swagger.io/v2/pet")
    public static Response postPetSuccess(Pet payload) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .post("v2/pet")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().response();
    }

    @Step("Отправить запрос POST https://petstore.swagger.io/v2/pet")
    public static Response postPetUnSuccess(Pet payload) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .post("v2/pet")
                .then()
                .spec(SpecHelper.getResponseSpec(404))
                .extract().response();
    }

    @Step("Отправить запрос DELETE https://petstore.swagger.io/v2/pet/(id)")
    public static Response deleteSuccessPet(String id) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .delete(String.format("v2/pet/%s", id))
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().response();

    }

    @Step("Отправить запрос DELETE https://petstore.swagger.io/v2/pet/(id)")
    public static Response deleteUnSuccessPet(String id) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .delete(String.format("v2/pet/%s", id))
                .then()
                .spec(SpecHelper.getResponseSpec(404))
                .extract().response();

    }

    @Step("Отправить запрос POST https://petstore.swagger.io/v2/user")
    public static Response postUserSuccess(User payload) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .post("v2/user")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().response();
    }

    @Step("Отправить запрос POST https://petstore.swagger.io/v2/user")
    public static Response postUserUnSuccess(User payload) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .post("v2/user")
                .then()
                .spec(SpecHelper.getResponseSpec(404))
                .extract().response();
    }

    @Step("Отправить запрос PUT https://petstore.swagger.io/v2/user/(username)")
    public static Response putUserSuccess(User payload, String username) {
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .put(String.format("v2/user/%s", username))
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().response();
    }

    @Step("Проверка ошибки от сервера")
    public void checkError(ApiResponse apiResponse) {
        Assertions.assertEquals(1, apiResponse.getCode());
        Assertions.assertEquals("error", apiResponse.getType());
        Assertions.assertEquals("Pet not found", apiResponse.getMessage());
    }

    @Step("Проверка соотвествия данных в теле запроса POST и в теле ответа GET")
    public void checkUpdateUser(User userUpdated, User payload) {
        Assertions.assertEquals(payload.getFirstName(), userUpdated.getFirstName());
        Assertions.assertEquals(payload.getLastName(), userUpdated.getLastName());
        Assertions.assertEquals(payload.getEMail(), userUpdated.getEMail());
        Assertions.assertEquals(payload.getPassword(), userUpdated.getPassword());
        Assertions.assertEquals(payload.getPhone(), userUpdated.getPhone());
        Assertions.assertEquals(payload.getUserStatus(), userUpdated.getUserStatus());
    }

}
