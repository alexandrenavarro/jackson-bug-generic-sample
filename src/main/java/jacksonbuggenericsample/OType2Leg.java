package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class OType2Leg<P extends OProduct> extends ORequestLeg {

    @JsonProperty("product")
    @NotNull
    @Valid
    private OType2Product<P> product;

    @Builder
    public OType2Leg(final Long id) {
        super(id);
        this.product = product;
    }
}
