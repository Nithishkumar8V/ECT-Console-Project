package EC;

public class BillCalc {
	public static double calculateBill(double units)
	{
		double bill=0;
		if(units<=100) {
			bill=units*1.5;
		} else if(units<=300) {
			bill=100*1.5 +(units-100)*2.5;
		} else if (units <= 500) {
			bill = 100 * 1.5 + 200 * 2.5 + (units - 300) * 4;
		} else {
			bill = 100 * 1.5 + 200 * 2.5 + 200 * 4 + (units - 500) * 6;
		}
	        bill += bill * 0.05; // 5% tax
	        return bill;
	}
}
