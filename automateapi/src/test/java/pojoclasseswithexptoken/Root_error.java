
package pojoclasseswithexptoken;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Root_error {

    @JsonProperty("error")
    private inner_error error;

    @JsonProperty("error")
    public inner_error getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(inner_error error) {
        this.error = error;
    }

}
