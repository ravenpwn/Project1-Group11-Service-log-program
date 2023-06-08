import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headers {
    @SerializedName("Content-Length")
    @Expose
    public String contentLength;
    @SerializedName("Keep-Alive")
    @Expose
    public String keepAlive;
    public String Connection;
    @SerializedName("Content-Type")
    @Expose
    public String contentType;

    public String toString(){
        return "[Content-Length="+contentLength+", Keep-Alive="+keepAlive+", Connection="+Connection+", Content-Type="+contentType+"]";
    }
}
