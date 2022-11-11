package tests;

import actions.Action;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.*;

public class Test_1 {
    Action action = new Action();

    @Test
    public void checkCreateOrderSuccess(){

        String orderId = "p21";
        String messageId;

        /**
         *    1. Створити замовлення використовуючи метод createOrder, використовуючи дані з опису (змінити orderId)
         *    - Перевірити вихідні данні успішної відповіді
         **/
        CreateOrderRequest createOrderRequest = new CreateOrderRequest("+380967896608", "9654", orderId, "60000",
                "9", "https://dpartnapu01.alfa.bank.int:8243/installmentseventwo/orders", "test@mytestemail.com");
        Responce createOrderResponce = action.createOrder(createOrderRequest);

        Assertions.assertNotNull(createOrderResponce.getMessageId());
        messageId = createOrderResponce.getMessageId();
        Responce createOrderSuccess = new Responce(orderId, messageId, "IN_PROCESSING", "Заказ в обработке!");
        Assertions.assertEquals(createOrderSuccess, createOrderResponce);

        /**
         *    2. Перевірити статус замовлення методом getOrder
         *    - Порівняти вихідні данні з данними, які використовувались при створенні заявки
         *    - Замовлення має мати статус INST_ALLOWED_OK
         **/
        GetOrderResponce getOrderObject = action.getOrder(createOrderRequest.getOrderId());
        GetOrderResponce getOrderSuccess = new GetOrderResponce(createOrderRequest);
        getOrderSuccess.setMessageId(messageId);
        getOrderSuccess.setStatusCode("INST_ALLOWED_OK");
        getOrderSuccess.setStatusText("");
        Assertions.assertEquals(getOrderSuccess, getOrderObject);


        /**
         *    3. Скасувати замовлення викликавши метод cancelOrder
         *    - Порівняти статус код і статус текст успішної відповіді (приклад 4)
         **/
        CancelRequest cancelRequest = new CancelRequest("null", messageId,"rc0101", "test");
        Responce cancelSuccess = new Responce(orderId, messageId, "CANCEL_IS_OK", "Отмена заказа с номером " + orderId + " в обработке.");
        Responce cancelResponce = action.cancelOrder(cancelRequest);
        Assertions.assertEquals(cancelSuccess, cancelResponce);
    }

    /**
     *    Некорректный номер заказа в createOrder
     **/
    @Test
    public void checkCreateOrderFailed(){
        CreateOrderRequest createOrderRequest = new CreateOrderRequest("+380967896608", "9654", "", "60000",
                    "9", "https://dpartnapu01.alfa.bank.int:8243/installmentseventwo/orders", "test@mytestemail.com");
        Responce responce = new Responce("null", "null", "INVALID_ORDERID", "Указан некорректный номер заказа!");
        Responce createOrderResponce = action.createOrder(createOrderRequest);
        Assertions.assertEquals(responce, createOrderResponce);
    }

    /**
     *    Несуществующий заказ в getOrder
     **/
    @Test
    public void checkGetOrderFailed(){
        Responce getOrderResponce = action.getOrderResponce("null");
        Responce responce = new Responce("null", "", "NO_APP", "Заказ не найден!");
        Assertions.assertEquals(responce, getOrderResponce);
    }

    /**
     *    Указан некорректный номер отмены в cancelOrder
     *    Начальные условия:
     *    1. Ордер("p77") в статусе wait, ok, error.
     **/
    @Test
    public void checkCancelOrderFailed(){
        String orderId = "p77";
        CancelRequest cancelRequest = new CancelRequest(orderId, "null", "", "test");
        Responce cancelSuccess = new Responce(orderId, "null", "INVALID_CANCELID", "Указан некорректный номер отмены!");
        Responce cancelResponce = action.cancelOrder(cancelRequest);
        Assertions.assertEquals(cancelSuccess, cancelResponce);
    }

    @Test
    public void JsonParsing_1() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"isCardAccount\":false,\"data\":{\"order_id\":\"p100\",\"message_id\":\"EB4BFBBCA7167857E0539B5A8F0ACB76\"}," +
                "\"isRevaluation\":false,\"userId\":20069,\"userLogin\":\"55555F3\",\"docIds\":[597405],\"locale\":\"UA\"}";

        JSON_1 object = objectMapper.readValue(json, JSON_1.class);
        System.out.println(object.toString());
        System.out.println(object.getData().toString());
    }

    @Test
    public void JsonParsing_2() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        String listOfJson = "[{\"isCard\":false,\"userPass\":\"test\",\"userLogin\":\"55555F3\",\"locale\":\"UA\"}," +
                "{\"isCard\":true,\"userPass\":\"test\",\"userLogin\":\"11111F3\",\"locale\":\"UK\"}]";

        JSON_2[] objects = objectMapper.readValue(listOfJson, JSON_2[].class);
        System.out.println(objects[0].toString());
        System.out.println(objects[1].toString());
    }
}
