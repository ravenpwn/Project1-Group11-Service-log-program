public class Response {

    public String protocol;
    public int status;
    public Headers headers;
    public String body;

    public String toString(){
        return "[protocol="+protocol+", status="+status+", Headers="+headers+", body="+body+"]";
    }
}
