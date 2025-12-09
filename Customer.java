package EC;

public class Customer {
	private int custid;
	private String name;
	private String address;
	private double preread;
	private double curread;
	private double totalbill;

	public Customer(int id,String name, String address,double pre,double cur, double bill)
	{
		this.custid=id;
		this.name=name;
		this.address=address;
		this.preread=pre;
		this.curread=cur;
		this.totalbill=bill;

	}
	public Customer(String name, String address)
	{
		this.name=name;
		this.address=address;
	}

	public int getcustid() {return custid;}
	public String getName() {return name;}
	public String getaddress() {return address;}
	public double getpre() {return preread;}
	public double getcur() {return curread;}
	public double gettotal() {return totalbill;}

	public void setpre(double preread)
	{
		this.preread=preread;
	}
	public void setcur(double curread)
	{
		this.curread=curread;
	}
	public void settotal(double totalbill)
	{
		this.totalbill=totalbill;
	}
}
