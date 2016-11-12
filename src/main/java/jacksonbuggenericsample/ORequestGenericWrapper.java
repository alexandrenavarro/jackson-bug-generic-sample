package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class ORequestGenericWrapper extends JSonGCFields {

    @JsonProperty("request")
    @NotNull
    @Valid
    private ORequest<? extends ORequestLeg> request;
    //private ORequest request;

}
