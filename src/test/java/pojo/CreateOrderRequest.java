package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderRequest {

    @JsonProperty("mPhone")
    private String mPhone;
    private String panEnd;
    private String orderId;
    private String orderSum;
    private String orderTerm;
    private String callBackURL;
    private String shopId; // optional
    private List<String> orderNom; // optional
    private String orderAdd; // optional
    private String orderVat; // optional
    private String eMailPartner;

    public CreateOrderRequest(@JsonProperty("mPhone") String mPhone, @JsonProperty("panEnd") String panEnd, @JsonProperty("orderId") String orderId,
                              @JsonProperty("orderSum") String orderSum, @JsonProperty("orderTerm") String orderTerm,
                              @JsonProperty("callBackURL") String callBackURL, @JsonProperty("eMailPartner") String eMailPartner) {
        this.mPhone = mPhone;
        this.panEnd = panEnd;
        this.orderId = orderId;
        this.orderSum = orderSum;
        this.orderTerm = orderTerm;
        this.callBackURL = callBackURL;
        this.eMailPartner = eMailPartner;
    }

    public CreateOrderRequest(@JsonProperty("mPhone") String mPhone, @JsonProperty("panEnd") String panEnd, @JsonProperty("orderId") String orderId,
                              @JsonProperty("orderSum") String orderSum, @JsonProperty("orderTerm") String orderTerm,
                              @JsonProperty("callBackURL") String callBackURL, @JsonProperty("shopId") String shopId,
                              @JsonProperty("orderNom") List<String> orderNom, @JsonProperty("orderAdd") String orderAdd,
                              @JsonProperty("orderVat") String orderVat, @JsonProperty("eMailPartner") String eMailPartner) {
        this.mPhone = mPhone;
        this.panEnd = panEnd;
        this.orderId = orderId;
        this.orderSum = orderSum;
        this.orderTerm = orderTerm;
        this.callBackURL = callBackURL;
        this.shopId = shopId;
        this.orderNom = orderNom;
        this.orderAdd = orderAdd;
        this.orderVat = orderVat;
        this.eMailPartner = eMailPartner;
    }
}
