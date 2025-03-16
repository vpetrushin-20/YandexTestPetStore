package apiTests;

import api.models.*;
import io.qameta.allure.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import steps.ReqresSteps;

import java.util.ArrayList;
import java.util.List;

@Epic("Api tests")
@Feature("PetStore service")
@Owner("Петрушин Вадим Васильевич")
public class PetStoreTest {

    private final ReqresSteps reqresSteps = new ReqresSteps();

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-2"})
    @DisplayName("Проверка метода GET на получение информации о питомце c некорректным id.")
    @Description("Проверка получения информации о питомце с некорректным id на граничных значенениях и проверка ошибки. Ожидаемый статус - 404")
    @Severity(SeverityLevel.NORMAL)
    public void unSuccessGetPet(String id) {
        ApiResponse apiResponse = reqresSteps.getPetIdUnSuccess(id);

        reqresSteps.checkError(apiResponse);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Проверка метода GET на получение информации о питомце с корректным id. Ожидаемый статус - 200")
    @Description("Запрос используется в основном для проверок других запросов")
    @Severity(SeverityLevel.NORMAL)
    public void successGetPet(String id) {
        reqresSteps.getPetIdSuccess(id);

    }

    @ParameterizedTest
    @ValueSource(strings = {"2134"})
    @DisplayName("Проверка метода POST на создание питомца с корректным id")
    @Description("Создание питомца с помощью POST запроса и последующая проверка с помощью запроса GET. Ожидаемый статус - 200")
    @Severity(SeverityLevel.CRITICAL)
    public void createPetSuccess(String id) {

        Category category = new Category(10, "dogs");

        String[] photoUrls = {"https://public.bnbstatic.com/static/content/square/images/4be4e4f6cab648438a0ca17af48af29c.png",
                "https://avatars.mds.yandex.net/i?id=0cb779723a193faebfc8eba53b88d36d_l-11492249-images-thumbs&n=13"};

        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1, "pet"));

        Pet payload = new Pet(2134, category, "dogeCoin", photoUrls, tags, Pet.Status.available);
        reqresSteps.postPetSuccess(payload);
        reqresSteps.getPetIdSuccess(id);

    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    @DisplayName("Проверка метода POST на создание питомца с некорректным id")
    @Description("Создание питомца с помощью POST с отрицательным id  и последующая проверка с помощью запроса GET. Ожидаемый статус - 404")
    @Severity(SeverityLevel.CRITICAL)
    public void createPetUnSuccess(String id) {

        Category category = new Category(10, "dogs");

        String[] photoUrls = {"https://public.bnbstatic.com/static/content/square/images/4be4e4f6cab648438a0ca17af48af29c.png",
                "https://avatars.mds.yandex.net/i?id=0cb779723a193faebfc8eba53b88d36d_l-11492249-images-thumbs&n=13"};

        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1, "pet"));

        Pet payload = new Pet(-1, category, "dogeCoin", photoUrls, tags, Pet.Status.available);
        reqresSteps.postPetUnSuccess(payload);
        reqresSteps.getPetIdSuccess(id);

    }

    @ParameterizedTest
    @ValueSource(strings = {"134"})
    @DisplayName("Проверка метода DELETE на удаление существующего питомца из базы ")
    @Description("Создание питомца с помощью POST, проверка существования с помощью GET, удаление питомца с помощью DELETE, вторая проверка с помощью GET и проверка ошибки. Ожидаемый статус код - 200")
    @Severity(SeverityLevel.CRITICAL)
    public void deletePetSuccess(String id) {

        Category category = new Category(10, "dogs");

        String[] photoUrls = {"https://public.bnbstatic.com/static/content/square/images/4be4e4f6cab648438a0ca17af48af29c.png",
                "https://avatars.mds.yandex.net/i?id=0cb779723a193faebfc8eba53b88d36d_l-11492249-images-thumbs&n=13"};

        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1, "pet"));

        Pet payload = new Pet(134, category, "dogeCoin", photoUrls, tags, Pet.Status.available);
        reqresSteps.postPetSuccess(payload);
        reqresSteps.getPetIdSuccess(id);
        reqresSteps.deleteSuccessPet(id);
        ApiResponse apiResponse = reqresSteps.getPetIdUnSuccess(id);
        reqresSteps.checkError(apiResponse);

    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "0.5", "03"})
    @DisplayName("Проверка метода DELETE на удаление несуществующего питомца из базы")
    @Description("Проверка возможности удаления пользователя с некорректным id - Ожидаемый статус код - 404.")
    @Severity(SeverityLevel.NORMAL)
    public void deletePetUnSuccess(String id) {

        reqresSteps.deleteUnSuccessPet(id);
    }

    @ParameterizedTest
    @ValueSource(strings = {"vadim134"})
    @DisplayName("Проверка метода POST на создание User с корректным username")
    @Description("Создание User с помощью POST запроса и последующая проверка с помощью запроса GET. Ожидаемый статус - 200")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserSuccess(String username) {

        User payload = new User(2015, username, "vadim", "petrushin",
                "uka1980@bk.ru", "1234", "8-800-555-35-35", "1");
        reqresSteps.postUserSuccess(payload);
        reqresSteps.getUserSuccess(username);

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -2})
    @DisplayName("Проверка метода POST на создание User с некорректным id")
    @Description("Создание User с помощью POST запроса и последующая проверка с помощью запроса GET. Ожидаемый статус - 404")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserUnSuccess(Integer id) {

        User payload = new User(id, "vadim134", "vadim", "petrushin",
                "uka1980@bk.ru", "1234", "8-800-555-35-35", "1");
        reqresSteps.postUserUnSuccess(payload);
        reqresSteps.getUserUnSuccess("vadim134");

    }

    @ParameterizedTest
    @ValueSource(strings = {"vadimos134"})
    @DisplayName("Проверка метода PUT на изменение данных юзера.")
    @Description("Создание User с помощью POST запроса, изменение его данных с помощью PUT и последующая проверка с помощью запроса GET и сравнения значений. Ожидаемый статус - 200")
    @Severity(SeverityLevel.CRITICAL)
    public void updateUserSuccess(String username) {

        User payload = new User(134, username, "vadim", "petrushin",
                "uka1980@bk.ru", "1234", "8-800-555-35-35", "1");
        reqresSteps.postUserSuccess(payload);
        reqresSteps.getUserSuccess(username);

        User payloadSec = new User(134, username, "danil", "ivanov",
                "kxkxkxkldl@mail.ru", "2345", "8-905-404-31-31", "1");
        reqresSteps.putUserSuccess(payloadSec, username);

        User userUpdated = reqresSteps.getUserSuccess(username);
        reqresSteps.checkUpdateUser(userUpdated, payloadSec);

    }

    @ParameterizedTest
    @ValueSource(strings = {"vadimosIk134"})
    @DisplayName("Проверка метода PUT на изменение данных юзера на некорректные.")
    @Description("Создание User с помощью POST запроса, изменение его данных с помощью PUT на некорректные . Ожидаемый статус - 404")
    @Severity(SeverityLevel.CRITICAL)
    public void updateUserUnSuccess(String username) {

        User payload = new User(227, username, "vadim", "petrushin",
                "uka1980@bk.ru", "1234", "8-800-555-35-35", "1");
        reqresSteps.postUserSuccess(payload);
        reqresSteps.getUserSuccess(username);

        User payloadSec = new User(227, username, "#@#@#@", "#@@##@",
                "dondodondo", "@@@@@@", "asdfghjkl", "1");
        reqresSteps.putUserSuccess(payloadSec, username);

        User userUpdated = reqresSteps.getUserSuccess(username);
        reqresSteps.checkUpdateUser(userUpdated, payload);

    }
}

