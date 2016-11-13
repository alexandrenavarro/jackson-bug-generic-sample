package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class ORequestGenericWrapper {

    @JsonProperty("request")
    private ORequest<? extends ORequestLeg> request; // Serialization does not work
    //private ORequest request; // Serialization works

}
