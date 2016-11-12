package jacksonbuggenericsample;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public abstract class JSonGCFields {

    private Map<String, Object> other = new HashMap<String, Object>();

    @JsonAnyGetter
    public final Map<String, Object> any() {
        return other;
    }

    @JsonAnySetter
    public final void set(String name, Object value) {
        other.put(name, value);
    }

    public final boolean hasUnknownProperties() {
        return !other.isEmpty();
    }
}
