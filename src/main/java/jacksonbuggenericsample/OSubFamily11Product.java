package jacksonbuggenericsample;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OSubFamily11Product extends OProduct {

    @Builder
    public OSubFamily11Product() {
        super(ESubFamily.SUB_FAMILY11);
    }

}
