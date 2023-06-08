import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Audit_data {

    @SerializedName("messages")
    @Expose
    private List<String> messages;
    @SerializedName("error_messages")
    @Expose
    private List<String> errorMessages;
    @SerializedName("action")
    @Expose
    private Action action;
    @SerializedName("stopwatch")
    @Expose
    private Stopwatch stopwatch;
    @SerializedName("response_body_dechunked")
    @Expose
    private boolean responseBodyDechunked;
    @SerializedName("producer")
    @Expose
    private List<String> producer;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("engine_mode")
    @Expose
    private String engineMode;

    public String toString(){
        return "[messages="+messages+", error_messages="+errorMessages+"]";
    }
}
