import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stopwatch {
    @SerializedName("p1")
    @Expose
    private long p1;
    @SerializedName("p2")
    @Expose
    private long p2;
    @SerializedName("p3")
    @Expose
    private long p3;
    @SerializedName("p4")
    @Expose
    private long p4;
    @SerializedName("p5")
    @Expose
    private long p5;
    @SerializedName("sr")
    @Expose
    private long sr;
    @SerializedName("sw")
    @Expose
    private long sw;
    @SerializedName("l")
    @Expose
    private long l;
    @SerializedName("gc")
    @Expose
    private long gc;
}
