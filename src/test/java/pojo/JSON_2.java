package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JSON_2 {

    private boolean isCard;
    private String userPass;
    private String userLogin;
    private String locale;

    @JsonCreator
    public JSON_2(@JsonProperty("isCard") boolean isCard, @JsonProperty("userPass") String userPass,
                  @JsonProperty("userLogin") String userLogin, @JsonProperty("locale") String locale) {
        this.isCard = isCard;
        this.userPass = userPass;
        this.userLogin = userLogin;
        this.locale = locale;
    }
}
