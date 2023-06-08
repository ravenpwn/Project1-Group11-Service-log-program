public class Request {

    public String request_line;
    public Header headers;

    public String toString(){
        return "[request_line="+request_line+", header="+headers+"]";
    }

}
