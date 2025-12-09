package EC;

import java.util.*;

public class MainTracker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CustDAO dao = new CustDAO();
        int choice;

        do {
            System.out.println("\n===== ELECTRICITY CONSUMPTION TRACKER =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Record Usage & Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = s.nextLine();
                    System.out.print("Enter Address: ");
                    String address = s.nextLine();
                    dao.addCust(new Customer(name, address));
                    break;

                case 2:
                    List<Customer> custList = dao.getAllCust();
                    if (custList.isEmpty()) {
                        System.out.println("⚠️ No customers found.");
                    } else {
                        System.out.println("\n--- CUSTOMER LIST ---");
                        for (Customer c : custList) {
                            System.out.printf(
                                "ID: %d | Name: %s | Address: %s | Prev: %.1f | Curr: %.1f | Bill: ₹%.2f%n",
                                c.getcustid(), c.getName(), c.getaddress(),
                                c.getpre(), c.getcur(), c.gettotal()
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int id = s.nextInt();
                    Customer c = dao.findCustomer(id);
                    if (c == null) {
                        System.out.println("❌ Customer Not Found!");
                        break;
                    }

                    System.out.printf("Previous Reading: %.1f%n", c.getcur());
                    System.out.print("Enter New Reading: ");
                    double nr = s.nextDouble();

                    double prev = c.getcur();
                    double units;

                    if (nr >= prev) {
                        units = nr - prev;
                    } else {
                        System.out.println("⚠️ Meter reset detected! Reading restarted from 0.");
                        units = nr;
                    }

                    double bill = BillCalc.calculateBill(units);
                    dao.updateReadingAndBill(id, nr, bill);
                    System.out.printf("✅ Units Used: %.1f | Bill Amount: ₹%.2f%n", units, bill);
                    break;

                case 4:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 4);

        s.close();
    }
}
