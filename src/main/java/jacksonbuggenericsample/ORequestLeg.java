package jacksonbuggenericsample;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * The type ORequest leg.
 *
 */
@Getter
@Setter
@ToString(callSuper = false)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "requestLegType",
        visible = true
)
@JsonSubTypes({
                      @JsonSubTypes.Type(value = OType1Leg.class, name = ERequestType.Constants.TYPE_1_REQUEST),
                      @JsonSubTypes.Type(value = OType2Leg.class, name = ERequestType.Constants.TYPE_2_REQUEST)
              })
public abstract class ORequestLeg {


    @JsonProperty("requestLegType")
    @NotNull
    protected final ERequestType requestLegType;

    @JsonProperty("id")
    protected Long id;

}
