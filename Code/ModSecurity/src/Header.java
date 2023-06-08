import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {

    public String host;
    public String Connection;
    @SerializedName("sec-ch-ua")
    @Expose
    public String secChUa;
    @SerializedName("sec-ch-ua-mobile")
    @Expose
    public String secChUaMobile;
    @SerializedName("sec-ch-ua-platform")
    @Expose
    public String secChUaPlatform;
    @SerializedName("Upgrade-Insecure-Requests")
    @Expose
    public String upgradeInsecureRequests;
    @SerializedName("User-Agent")
    @Expose
    public String userAgent;
    public String Accept;
    @SerializedName("Sec-Fetch-Site")
    @Expose
    public String secFetchSite;
    @SerializedName("Sec-Fetch-Mode")
    @Expose
    public String secFetchMode;
    @SerializedName("Sec-Fetch-User")
    @Expose
    public String secFetchUser;
    @SerializedName("Sec-Fetch-Dest")
    @Expose
    public String secFetchDest;
    public String Referer;
    @SerializedName("Accept-Encoding")
    @Expose
    public String acceptEncoding;
    @SerializedName("Accept-Language")
    @Expose
    public String acceptLanguage;
    public String Cookie;

    public String toString(){
        return "[sec-ch-ua="+secChUa+", host="+host+", Connection="+Connection+", sec-ch-ua-mobile="+secChUaMobile+", sec-ch-ua-platform="+secChUaPlatform+", Upgrade-Insecure-Requests="+upgradeInsecureRequests+", User-Agent="+userAgent+"]";
    }

}