package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "requestType",
        visible = true
)
@JsonSubTypes({
                      @JsonSubTypes.Type(value = OType1Request.class, name = ERequestType.Constants.TYPE_1_REQUEST),
                      @JsonSubTypes.Type(value = OType2Request.class, name = ERequestType.Constants.TYPE_2_REQUEST)
              })
public abstract class ORequest<P extends OProduct, L extends ORequestLeg<P>> {

    @JsonProperty("requestType")
    protected ERequestType requestType;

    @JsonProperty("legs")
    private List<L> legs;

}
