package jacksonbuggenericsample;

import lombok.Builder;
import lombok.ToString;

@ToString(callSuper = true)
public class OUnknownProduct extends OProduct {

    @Builder
    public OUnknownProduct() {
        super(ESubFamily.UNKNOWN);
    }
}
