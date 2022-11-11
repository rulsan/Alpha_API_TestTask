package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class Responce {

    @NonNull
    private String orderId;
    @NonNull
    private String messageId;
    @NonNull
    private String statusCode;
    @NonNull
    private String statusText;

    public Responce(@JsonProperty("orderId") String orderId, @JsonProperty("messageId") String messageId,
                         @JsonProperty("statusCode") String statusCode, @JsonProperty("statusText") String statusText) {
        this.orderId = orderId;
        this.messageId = messageId;
        this.statusCode = statusCode;
        this.statusText = statusText;
    }
}
