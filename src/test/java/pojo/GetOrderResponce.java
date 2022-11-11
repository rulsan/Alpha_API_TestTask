package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrderResponce {

    private String messageId;
    private String orderId;
    private String statusCode;
    private String statusText;
    private String mPhone;
    private String panEnd;
    private String orderSum;
    private String orderTerm;
    private String shopId;
    private List<String> orderNom;
    private String orderAdd;

    public GetOrderResponce(@JsonProperty("messageId") String messageId, @JsonProperty("orderId") String orderId, @JsonProperty("statusCode") String statusCode,
                            @JsonProperty("statusText") String statusText, @JsonProperty("mPhone") String mPhone, @JsonProperty("panEnd") String panEnd,
                            @JsonProperty("orderSum") String orderSum, @JsonProperty("orderTerm") String orderTerm, @JsonProperty("shopId") String shopId,
                            @JsonProperty("orderNom") List<String> orderNom, @JsonProperty("orderAdd") String orderAdd) {
        this.messageId = messageId;
        this.orderId = orderId;
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.mPhone = mPhone;
        this.panEnd = panEnd;
        this.orderSum = orderSum;
        this.orderTerm = orderTerm;
        this.shopId = shopId;
        this.orderNom = orderNom;
        this.orderAdd = orderAdd;
    }

    public GetOrderResponce(CreateOrderRequest createOrderRequest){
        this.orderId = createOrderRequest.getOrderId();
        this.mPhone = createOrderRequest.getMPhone();
        this.panEnd = createOrderRequest.getPanEnd();
        this.orderSum = createOrderRequest.getOrderSum();
        this.orderTerm = createOrderRequest.getOrderTerm();
        this.shopId = createOrderRequest.getShopId();
        this.orderNom = createOrderRequest.getOrderNom();
        this.orderAdd = createOrderRequest.getOrderAdd();
    }
}
