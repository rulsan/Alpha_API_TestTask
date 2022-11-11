package actions;

import io.restassured.http.ContentType;
import pojo.CancelRequest;
import pojo.CreateOrderRequest;
import pojo.GetOrderResponce;
import pojo.Responce;
import specifications.Specifications;
import static io.restassured.RestAssured.given;

public class Action {

    private static final String PARTNER_ID = "partner";

    public Responce createOrder(CreateOrderRequest createOrderRequest){
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        return given()
                .contentType(ContentType.JSON)
                .body(createOrderRequest)
                .when()
                .post("createOrder/" + PARTNER_ID)
                .then()
                .extract().as(Responce.class);
    }

    public GetOrderResponce getOrder(String orderId){
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        return given()
                .when()
                .param("orderId", orderId)
                .get("getOrder/" + PARTNER_ID)
                .then()
                .extract().as(GetOrderResponce.class);
    }

    public Responce getOrderResponce(String orderId){
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        return given()
                .when()
                .param("orderId", orderId)
                .get("getOrder/" + PARTNER_ID)
                .then()
                .extract().as(Responce.class);
    }

    public Responce cancelOrder(CancelRequest cancelRequest){
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        return given()
                .contentType(ContentType.JSON)
                .body(cancelRequest)
                .when()
                .post("cancelOrder/" + PARTNER_ID)
                .then()
                .extract().as(Responce.class);
    }
}
