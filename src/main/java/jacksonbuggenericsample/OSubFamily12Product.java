package jacksonbuggenericsample;

import lombok.Builder;
import lombok.ToString;

@ToString(callSuper = true)
public class OSubFamily12Product extends OProduct {

    @Builder
    public OSubFamily12Product() {
        super(ESubFamily.SUB_FAMILY12);
    }
}
