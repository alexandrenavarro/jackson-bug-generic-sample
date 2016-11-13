package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = OProduct.JSON_DISCRIMINATOR_FIELD,
        visible = true
)
@JsonSubTypes({
                      @JsonSubTypes.Type(value = OTypeAProduct.class, name = EProductType.Constants.TYPE_A_PRODUCT),
                      @JsonSubTypes.Type(value = OTypeBProduct.class, name = EProductType.Constants.TYPE_B_PRODUCT),
              })
public abstract class OProduct  {

    public static final String JSON_DISCRIMINATOR_FIELD = "productType";

    @JsonProperty("productType")
    @NotNull
    protected final EProductType productType;

    @java.beans.ConstructorProperties({"productType"})
    protected OProduct(final EProductType productType) {
        this.productType = productType;
    }

}
