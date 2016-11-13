package jacksonbuggenericsample;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OType1Request<P extends OProduct> extends ORequest<OType1Leg<P>> {

    public OType1Request() {
        this.requestType = ERequestType.TYPE_1_REQUEST;
    }

    public OType1Request(final @Singular List<OType1Leg<P>> legs) {
        super(
                ERequestType.TYPE_1_REQUEST,
                legs);
    }
}
