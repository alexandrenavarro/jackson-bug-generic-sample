package jacksonbuggenericsample;

import lombok.*;

@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class OType2Leg<T extends OProduct> extends ORequestLeg<T> {


    public OType2Leg() {
        super(ERequestType.TYPE_2_REQUEST, 0l);
    }

    public OType2Leg(Long id) {
        super(ERequestType.TYPE_2_REQUEST, id);
    }


}
