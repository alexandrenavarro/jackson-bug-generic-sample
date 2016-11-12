package jacksonbuggenericsample;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The type ORequest leg.
 *
 */
@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        visible = true
)
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.EXISTING_PROPERTY,
//        property = "requestType",
//        visible = true
//)
//@JsonSubTypes({
//                      @JsonSubTypes.Type(value = OOtcLeg.class, name = ERequestType.Constants.TYPE1),
//                      @JsonSubTypes.Type(value = OListedLeg.class, name = ERequestType.Constants.TYPE2)
//              })
public abstract class ORequestLeg extends JSonGCFields {


    @JsonProperty("id")
    @NotNull
    @Min(value = 1)
    private Long id;

}
