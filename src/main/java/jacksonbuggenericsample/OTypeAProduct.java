package jacksonbuggenericsample;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OTypeAProduct extends OProduct {


    public OTypeAProduct() {
        super(EProductType.TYPE_A_PRODUCT);
    }

}
