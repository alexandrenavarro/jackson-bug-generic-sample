package jacksonbuggenericsample;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

@Slf4j
public class ORequestWrapperTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    // Does work on jackson 2.6.7 but not anymore in jackson 2.7 or 2.8.4
    public void testORequestGenericWrapper() {

        final OType1Request<OTypeAProduct> oType2ProductOType1Request = new OType1Request<>(Collections.singletonList(new OType1Leg<OTypeAProduct>(1l, new OTypeAProduct())));
        final ORequest<?, ?> oTypeAProductOType1Request2 = oType2ProductOType1Request;
        final ORequestGenericWrapper requestWrapper = new ORequestGenericWrapper((ORequest<OProduct, ORequestLeg<OProduct>>) oTypeAProductOType1Request2);

        try {
            final String
                    s =
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestWrapper);
            final ORequestGenericWrapper destRequestWrapper = objectMapper.readValue(s, ORequestGenericWrapper.class);
            Assertions.assertThat(((OType1Leg) (destRequestWrapper.getRequest().getLegs().get(0))).getProduct()
                    .getProductType())
                    .isEqualTo(
                            EProductType.TYPE_A_PRODUCT);


        } catch (IOException aE) {
            Assertions.fail("Fail", aE);
        }
    }

    @Test
    public void testORequestGenericWrapperWithType2Leg() {

        final ORequestGenericWrapper requestWrapper = new ORequestGenericWrapper(
                new OType2Request(Collections.singletonList(new OType2Leg(1l))));

        try {
            final String
                    s =
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestWrapper);
            final ORequestGenericWrapper destRequestWrapper = objectMapper.readValue(s, ORequestGenericWrapper.class);
            Assertions.assertThat(((OType2Leg) ((destRequestWrapper.getRequest().getLegs().get(0)))).getId()).isEqualTo(1l);


        } catch (IOException aE) {
            Assertions.fail("Fail", aE);
        }
    }


    @Test
    public void testORequestObjectWrapper() {
        final ORequestObjectWrapper requestWrapper = new ORequestObjectWrapper(
                new OType1Request<OTypeAProduct>(Collections.singletonList(new OType1Leg<OTypeAProduct>(1l, new OTypeAProduct()))));
        try {
            final String
                    s =
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestWrapper);
            final ORequestObjectWrapper destRequestWrapper = objectMapper.readValue(s, ORequestObjectWrapper.class);
            Assertions.assertThat(((OType1Leg) (destRequestWrapper.getRequest().getLegs().get(0))).getProduct()
                    .getProductType())
                    .isEqualTo(
                            EProductType.TYPE_A_PRODUCT);


        } catch (IOException aE) {
            Assertions.fail("Fail", aE);
        }
    }

    @Test
    public void testORequest() {
        final OType1Request<OTypeAProduct> oType2ProductOType1Request = new OType1Request<>(Collections.singletonList(new OType1Leg<OTypeAProduct>(1l, new OTypeAProduct())));
        final ORequest<?, ?> oTypeAProductOType1Request2 = oType2ProductOType1Request;


        try {
            final String
                    s =
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(oTypeAProductOType1Request2);
            final ORequest destRequestWrapper = objectMapper.readValue(s, ORequest.class);
            Assertions.assertThat(((OType1Leg) (destRequestWrapper.getLegs().get(0))).getProduct().getProductType())
                    .isEqualTo(
                            EProductType.TYPE_A_PRODUCT);


        } catch (IOException aE) {
            Assertions.fail("Fail", aE);
        }
    }

    @Test
    public void testORequestWithBuilder() {
        final OType1Request<OTypeAProduct> oType2ProductOType1Request = new OType1Request<>(Collections.singletonList(OType1Leg.<OTypeAProduct>builder().product(new OTypeAProduct()).build()));

    }

}