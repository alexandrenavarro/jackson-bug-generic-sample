package jacksonbuggenericsample;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
public class OType2Request extends ORequest<OType2Leg> {

    public OType2Request() {
        this.requestType = ERequestType.TYPE2;
    }

    @Builder
    public OType2Request(final @Singular List<OType2Leg> legs) {
        super(
                ERequestType.TYPE2,
                legs);
    }
}
