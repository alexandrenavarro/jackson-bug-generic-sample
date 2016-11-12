package jacksonbuggenericsample;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class ORequestWrapperTest {

    @Test
    // Does work on jackson 2.6.7 but not anymore in jackson 2.7 or 2.8.4
    public void testORequestGenericWrapper() {
        final ORequestGenericWrapper requestWrapper = ORequestGenericWrapper.<OSubFamily11Product, OType1Leg<OSubFamily11Product>>builder()
                .request(OType1Request.<OSubFamily11Product>builder()
                                 .leg(OType1Leg.<OSubFamily11Product>builder()
                                              .product(OSubFamily11Product.builder().build())
                                              .build())
                                 .build()
                )
                .build();
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String
                    s                                       =
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestWrapper);
            final ORequestGenericWrapper destRequestWrapper = objectMapper.readValue(s, ORequestGenericWrapper.class);
            Assertions.assertThat(((OType1Leg) (destRequestWrapper.getRequest().getLegs().get(0))).getProduct()
                                                                                                  .getSubFamily())
                      .isEqualTo(
                              ESubFamily.SUB_FAMILY11);


        } catch (IOException aE) {
            Assertions.fail("Fail", aE);
        }
    }

    @Test
    public void testORequestObjectWrapper() {
        final ORequestObjectWrapper requestWrapper = ORequestObjectWrapper.<OSubFamily11Product, OType1Leg<OSubFamily11Product>>builder()
                .request(OType1Request.<OSubFamily11Product>builder()
                                 .leg(OType1Leg.<OSubFamily11Product>builder()
                                              .product(OSubFamily11Product.builder().build())
                                              .build())
                                 .build()
                )
                .build();
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String
                    s                                      =
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestWrapper);
            final ORequestObjectWrapper destRequestWrapper = objectMapper.readValue(s, ORequestObjectWrapper.class);
            Assertions.assertThat(((OType1Leg) (destRequestWrapper.getRequest().getLegs().get(0))).getProduct()
                                                                                                  .getSubFamily())
                      .isEqualTo(
                              ESubFamily.SUB_FAMILY11);


        } catch (IOException aE) {
            Assertions.fail("Fail", aE);
        }
    }

    @Test
    public void testORequest() {
        final ORequest<? extends ORequestLeg> request = OType1Request.<OSubFamily11Product>builder()
                .leg(OType1Leg.<OSubFamily11Product>builder()
                             .product(OSubFamily11Product.builder().build())
                             .id(11l)
                             .build())
                .build();
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String
                           s                  =
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
            final ORequest destRequestWrapper = objectMapper.readValue(s, ORequest.class);
            Assertions.assertThat(((OType1Leg) (destRequestWrapper.getLegs().get(0))).getProduct().getSubFamily())
                      .isEqualTo(
                              ESubFamily.SUB_FAMILY11);


        } catch (IOException aE) {
            Assertions.fail("Fail", aE);
        }
    }
}