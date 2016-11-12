package jacksonbuggenericsample;

import lombok.Getter;

public enum ESubFamily {

    SUB_FAMILY11(EFamily.FAMILY1),
    SUB_FAMILY12(EFamily.FAMILY1),
    SUB_FAMILY13(EFamily.FAMILY1),
    SUB_FAMILY21(EFamily.FAMILY2),

    UNKNOWN(EFamily.UNKNOWN_FAMILY);

    @Getter
    private EFamily family;

    ESubFamily(EFamily aFamily) {
        this.family = aFamily;
    }

    public interface Constants {
        String SUB_FAMILY11 = "SUB_FAMILY11";
        String SUB_FAMILY12 = "SUB_FAMILY12";
        String SUB_FAMILY13 = "SUB_FAMILY13";
        String SUB_FAMILY21 = "SUB_FAMILY21";

        String UNKNOWN = "UNKNOWN_FAMILY";
    }
}
