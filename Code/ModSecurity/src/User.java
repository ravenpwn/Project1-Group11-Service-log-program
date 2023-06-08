public class User {

    public Transaction transaction;
    public Request request;
    public Response response;
    public Audit_data audit_data;   // public String audit_data;

    public User(Transaction transaction, Request request, Response response , Audit_data audit_data) {
        this.transaction = transaction;
        this.request = request;
        this.response = response;
        this.audit_data = audit_data;

    }

    @Override
    public String toString(){
        return "LogBean[Transaction="+transaction+", request="+request+", response="+response+", audit_data="+audit_data+"]";
    }
}
// getters and setters, toString() .... (omitted for brevity)
