package jacksonbuggenericsample;

import lombok.Singular;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
public class OType2Request<P extends OProduct> extends ORequest<P, OType2Leg<P>> {

    public OType2Request() {
        this.requestType = ERequestType.TYPE_2_REQUEST;
    }


    public OType2Request(final @Singular List<OType2Leg<P>> legs) {
        super(
                ERequestType.TYPE_2_REQUEST,
                legs);
    }
}
