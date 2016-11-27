package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class OType1Leg<T extends OProduct> extends ORequestLeg<T> {

    @JsonProperty("product")
    private T product;

    public OType1Leg(){
        super(ERequestType.TYPE_1_REQUEST, 0l);
    }

    public OType1Leg(final Long id,
                     final T product
    ) {
        super(ERequestType.TYPE_1_REQUEST, id);
        this.product = product;
    }

       // What @Builder generate in lombok
//    public static <T extends OProduct> OType1LegBuilder<T> builder() {
//        return new OType1LegBuilder<T>();
//    }
//
//    public static class OType1LegBuilder<T extends OProduct> {
//        private Long id;
//        private T product;
//
//        OType1LegBuilder() {
//        }
//
//        public OType1Leg.OType1LegBuilder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public OType1Leg.OType1LegBuilder product(T product) {
//            this.product = product;
//            return this;
//        }
//
//        public OType1Leg<T> build() {
//            return new OType1Leg(id, product);
//        }
//
//        public String toString() {
//            return "jacksonbuggenericsample.OType1Leg.OType1LegBuilder(id=" + this.id + ", product=" + this.product + ")";
//        }
//    }


    // What @Builder should generate in lombok
    public static <TT extends OProduct> OType1LegBuilder<TT> builder() {
        return new OType1LegBuilder<TT>();
    }


    public static class OType1LegBuilder<T extends OProduct> {
        private T product;
        private Long id;

        OType1LegBuilder() {
        }

        public OType1Leg.OType1LegBuilder<T> product(T product) {
            this.product = product;
            return this;
        }

        public OType1Leg.OType1LegBuilder<T> id(Long id) {
            this.id = id;
            return this;
        }

        public OType1Leg<T> build() {
            return new OType1Leg<T>(id, product);
        }

        public String toString() {
            return "jacksonbuggenericsample.OType1Leg.OType1LegBuilder(product=" + this.product + ")";
        }
    }



}
