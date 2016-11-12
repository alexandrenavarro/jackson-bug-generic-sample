package jacksonbuggenericsample;

import lombok.Builder;
import lombok.ToString;

@ToString(callSuper = true)
public class OSubFamily21Product extends OProduct {

    @Builder
    public OSubFamily21Product() {
        super(ESubFamily.SUB_FAMILY21);
    }
}
