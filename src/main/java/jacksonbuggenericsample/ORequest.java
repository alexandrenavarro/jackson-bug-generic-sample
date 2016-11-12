package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
                      @JsonSubTypes.Type(value = OType1Request.class, name = ERequestType.Constants.TYPE1),
                      @JsonSubTypes.Type(value = OType2Request.class, name = ERequestType.Constants.TYPE2)
              })
public abstract class ORequest<T extends ORequestLeg> {

    @JsonProperty("requestType")
    @NotNull
    @Setter(AccessLevel.NONE)
    protected ERequestType requestType;

    @JsonProperty("legs")
    @NotNull
    @Size(min = 1)
    @Valid
    private List<T> legs;

}
