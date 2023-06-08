import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Action {
    @SerializedName("intercepted")
    @Expose
    private boolean intercepted;
    @SerializedName("phase")
    @Expose
    private long phase;
    @SerializedName("message")
    @Expose
    private String message;
}
