package jacksonbuggenericsample;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class OTypeBProduct extends OProduct {


    public OTypeBProduct() {
        super(EProductType.TYPE_B_PRODUCT);
    }
}
