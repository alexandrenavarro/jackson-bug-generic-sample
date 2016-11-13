package jacksonbuggenericsample;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class OType2Leg extends ORequestLeg {


    public OType2Leg() {
        super(ERequestType.TYPE_2_REQUEST, 0l);
    }

    public OType2Leg(Long id) {
        super(ERequestType.TYPE_2_REQUEST, id);
    }


}
