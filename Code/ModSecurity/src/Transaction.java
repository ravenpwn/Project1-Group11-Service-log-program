public class Transaction {

    public String time;
    public String transaction_id;
    public String remote_address;
    public int remote_port;

    public String local_address;

    public int local_port;
    @Override
    public String toString(){
        return "[time="+time+", transaction_id="+transaction_id+", remote_address="+remote_address+", remote_port="+remote_port+", local_address="+local_address+", local_port="+local_port+"]";
    }
}
