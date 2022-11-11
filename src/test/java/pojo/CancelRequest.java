package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CancelRequest {

    private String orderId;
    private String messageId;
    private String cancelId;
    private String reasonCancel;

    public CancelRequest(@JsonProperty("orderId") String orderId, @JsonProperty("messageId") String messageId,
                         @JsonProperty("cancelId") String cancelId, @JsonProperty("reasonCancel") String reasonCancel) {
        this.orderId = orderId;
        this.messageId = messageId;
        this.cancelId = cancelId;
        this.reasonCancel = reasonCancel;
    }
}
