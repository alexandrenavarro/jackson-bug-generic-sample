package jacksonbuggenericsample;

public enum EProductType {

    TYPE_A_PRODUCT(),
    TYPE_B_PRODUCT();


    public interface Constants {
        String TYPE_A_PRODUCT = "TYPE_A_PRODUCT";
        String TYPE_B_PRODUCT = "TYPE_B_PRODUCT";
    }
}
