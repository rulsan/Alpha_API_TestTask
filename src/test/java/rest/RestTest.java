package rest;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class RestTest {

    public ExtractableResponse getObj(String http){
        return given().when().get(http).then().contentType(ContentType.JSON).extract();
    }

    /**
     *    1. Створити замовлення використовуючи метод createOrder, використовуючи дані з опису (змінити orderId)
     *    - Перевірити вихідні данні успішної відповіді
     *    2. Перевірити статус замовлення методом getOrder
     *    - Порівняти вихідні данні з данними, які використовувались при створенні заявки
     *    - Замовлення має мати статус INST_ALLOWED_OK
     *    3. Скасувати замовлення викликавши метод cancelOrder
     *    - Порівняти статус код і статус текст успішної відповіді (приклад 4)
     **/

    @Test
    public void checkOrderCreation(){
        Specification
    }

}
