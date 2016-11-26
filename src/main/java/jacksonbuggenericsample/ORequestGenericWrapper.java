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
    private ORequest<OProduct, ORequestLeg<OProduct>> request;

}
