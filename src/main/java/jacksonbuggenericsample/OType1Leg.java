package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class OType1Leg<T extends OProduct> extends ORequestLeg {

    @JsonProperty("product")
    @NotNull
    @Valid
    private T product;

    public OType1Leg(){
        super(1l);
    }

    @Builder
    public OType1Leg(final Long id,
                     final T product
    ) {
        super(id);
        this.product = product;
    }
}
