package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JSON_1 {

    private boolean isCardAccount;
    private OrderBase data;
    private boolean isRevaluation;
    private String userId;
    private String userLogin;
    private List<String> docIds;
    private String locale;

    @JsonCreator
    public JSON_1(@JsonProperty("isCardAccount") boolean isCardAccount, @JsonProperty("data") OrderBase data,
                  @JsonProperty("isRevaluation") boolean isRevaluation, @JsonProperty("userId") String userId,
                  @JsonProperty("userLogin") String userLogin, @JsonProperty("docIds") List<String> docIds,
                  @JsonProperty("locale") String locale) {
        this.isCardAccount = isCardAccount;
        this.data = data;
        this.isRevaluation = isRevaluation;
        this.userId = userId;
        this.userLogin = userLogin;
        this.docIds = docIds;
        this.locale = locale;
    }
}
