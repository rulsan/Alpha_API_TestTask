package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private String mPhone;
    private int panEnd;
    private String shopId;
    private String orderId;
    private int orderSum;
    private int orderTerm;
    private String eMailPartner;
    private String callBackURL;

    public Order() {}

    @JsonCreator
    public Order(@JsonProperty("mPhone") String mPhone, @JsonProperty("panEnd") int panEnd, @JsonProperty("orderId") String orderId,
                 @JsonProperty("orderSum") int orderSum, @JsonProperty("orderTerm") int orderTerm, @JsonProperty("eMailPartner") String eMailPartner,
                 @JsonProperty("callBackURL") String callBackURL) {
        this.mPhone = mPhone;
        this.panEnd = panEnd;
        this.orderId = orderId;
        this.orderSum = orderSum;
        this.orderTerm = orderTerm;
        this.eMailPartner = eMailPartner;
        this.callBackURL = callBackURL;
    }

}


