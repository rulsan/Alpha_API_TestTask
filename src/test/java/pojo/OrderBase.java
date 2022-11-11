package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBase {

    private String order_id;
    private String message_id;

    public OrderBase(@JsonProperty("order_id") String order_id, @JsonProperty("messageId") String message_id) {
        this.order_id = order_id;
        this.message_id = message_id;
    }
}
