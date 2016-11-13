package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class OType1Leg<T extends OProduct> extends ORequestLeg {

    @JsonProperty("product")
    private T product;

    public OType1Leg(){
        super(ERequestType.TYPE_1_REQUEST, 0l);
    }

    public OType1Leg(final Long id,
                     final T product
    ) {
        super(ERequestType.TYPE_1_REQUEST, id);
        this.product = product;
    }
}
