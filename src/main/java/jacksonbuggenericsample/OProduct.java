package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
                      @JsonSubTypes.Type(value = OSubFamily11Product.class, name = ESubFamily.Constants.SUB_FAMILY11),
                      @JsonSubTypes.Type(value = OSubFamily12Product.class, name = ESubFamily.Constants.SUB_FAMILY12),
                      @JsonSubTypes.Type(value = OSubFamily21Product.class, name = ESubFamily.Constants.SUB_FAMILY21),
                      @JsonSubTypes.Type(value = OUnknownProduct.class, name = ESubFamily.Constants.UNKNOWN),
              })
public abstract class OProduct extends JSonGCFields {

    public static final String JSON_DISCRIMINATOR_FIELD = "subFamily";

    @JsonProperty("subFamily")
    @NotNull
    protected final ESubFamily subFamily;

    @java.beans.ConstructorProperties({"subFamily"})
    protected OProduct(final ESubFamily subFamily) {
        this.subFamily = subFamily;
    }

    @JsonIgnore
    public EFamily getFamily() {
        return getSubFamily().getFamily();
    }
}
