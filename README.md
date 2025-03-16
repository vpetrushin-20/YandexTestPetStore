<h1 align="center">Всем привет! Это мой проект по Автоматизации тестирования сервиса PetStore
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
<h3 align="center">Сценарий 1 </h3>
<h3 align="center">Проверка метода GET на получение информации о питомце c некорректным id. </h3>
<h3 align="center">unSuccessGetPet </h3>

1.Отправить сервису запрос GET https://petstore.swagger.io/v2/pet/(id) на поиск питомца с невалидными id (ожидаемый статус 404)
<h3 align="center">Сценарий 2 </h3>
<h3 align="center">Проверка метода GET на получение информации о питомце с корректным id. </h3>
<h3 align="center">successGetPet </h3>

1.Отправить сервису запрос GET https://petstore.swagger.io/v2/pet/(id) на поиск питомца с валидными id (ожидаемый статус 200)
<h3 align="center">Сценарий 3 </h3>
<h3 align="center">Проверка метода POST на создание питомца с корректным id </h3>
<h3 align="center">createPetSuccess </h3>

1.Отправить запрос POST https://petstore.swagger.io/v2/pet на создание питомца с валидными данными (ожидаемый статус 200)

2.Осуществить проверку отправкой сервису запрос GET https://petstore.swagger.io/v2/pet/(id) (ожидаемый статус 200)
<h3 align="center">Сценарий 4 </h3>
<h3 align="center">Проверка метода POST на создание питомца с некорректным id </h3>
<h3 align="center">createPetUnSuccess </h3>

1.Отправить запрос POST https://petstore.swagger.io/v2/pet на создание питомца с невалидными данными (ожидаемый статус 404)

2.Осущетвить проверку отправкой сервису запрос GET https://petstore.swagger.io/v2/pet/(id) (ожидаемый статус 404)
<h3 align="center">Сценарий 5 </h3>
<h3 align="center">Проверка метода DELETE на удаление существующего питомца из базы </h3>
<h3 align="center">deletePetSuccess </h3>

1.Отправить запрос POST https://petstore.swagger.io/v2/pet (ожидаемый статус 200)

2.Осущетвить проверку отправкой сервису запрос GET https://petstore.swagger.io/v2/pet/(id) (ожидаемый статус 200)

3.Отправить запрос DELETE https://petstore.swagger.io/v2/pet/(id) (ожидаемый статус 200)

4.Осущетвить проверку отправкой сервису запрос GET https://petstore.swagger.io/v2/pet/(id) (ожидаемый статус 404)

5.Проверить текст ошибки
<h3 align="center">Сценарий 6 </h3>
<h3 align="center">Проверка метода DELETE на удаление несуществующего питомца из базы </h3>
<h3 align="center">deletePetUnSuccess </h3>

1.Отправить запрос DELETE https://petstore.swagger.io/v2/pet/(id) с некорректным id (ожидаемый статус 404)
<h3 align="center">Сценарий 7 </h3>
<h3 align="center">Проверка метода POST на создание User с корректным username </h3>
<h3 align="center">createUserSuccess </h3>

1.Отправить запрос POST https://petstore.swagger.io/v2/user на создание пользователя с валидными данными (ождидаемый статус - 200)

2.Осуществить проверку с помощью отправки запроса GET https://petstore.swagger.io/v2/user/(username) (ождидаемый статус - 200)
<h3 align="center">Сценарий 8 </h3>
<h3 align="center">Проверка метода POST на создание User с некорректным id </h3>
<h3 align="center">createUserUnSuccess </h3>

1.Отправить запрос POST https://petstore.swagger.io/v2/user с некорректным id (ождидаемый статус - 404)

2.Осуществить проврку с помощью отправки запроса GET https://petstore.swagger.io/v2/user/(username) (ождидаемый статус - 404)
<h3 align="center">Сценарий 9 </h3>
<h3 align="center">Проверка метода PUT на изменение данных юзера. </h3>
<h3 align="center">updateUserSuccess </h3>

1.Отправить запрос POST https://petstore.swagger.io/v2/user на создание пользователя с валидными данными (ождидаемый статус - 200)

2.Осуществить проверку с помощью отправки запроса GET https://petstore.swagger.io/v2/user/(username) (ождидаемый статус - 200)

3.Отправить запрос PUT https://petstore.swagger.io/v2/user/(username) (ожидаемый статус 200)

4.Осуществить проверку с помощью отправки запроса GET https://petstore.swagger.io/v2/user/(username) (ождидаемый статус - 200)

5.Осуществить проверку данных передающихся в теле нового объекта PUT и данных в GET запросе
<h3 align="center">Сценарий 10 </h3>
<h3 align="center">Проверка метода PUT на изменение данных юзера на некорректные. </h3>
<h3 align="center">updateUserUnSuccess </h3>

1.Отправить запрос POST https://petstore.swagger.io/v2/user на создание пользователя с валидными данными (ождидаемый статус - 200)

2.Осуществить проверку с помощью отправки запроса GET https://petstore.swagger.io/v2/user/(username) (ождидаемый статус - 200)

3.Отправить запрос PUT https://petstore.swagger.io/v2/user/(username) (ожидаемый статус 200)

4.Осуществить проверку с помощью отправки запроса GET https://petstore.swagger.io/v2/user/(username) (ождидаемый статус - 200)

5.Осуществить проверку данных передающихся в теле изначально созданного объекта POST и данных в GET запросе после неудачного обновления данных.

