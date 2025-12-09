package EC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustDAO {

    public void addCust(Customer c) {
        String sql = "INSERT INTO customers(name, address, previous_reading, current_reading, total_bill) VALUES (?, ?, 0, 0, 0)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getaddress());
            ps.executeUpdate();
            System.out.println("✅ Customer added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCust() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Customer c = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("previous_reading"),
                        rs.getDouble("current_reading"),
                        rs.getDouble("total_bill")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Customer findCustomer(int id) {
        String sql = "SELECT * FROM customers WHERE customer_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("previous_reading"),
                        rs.getDouble("current_reading"),
                        rs.getDouble("total_bill")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateReadingAndBill(int id, double newReading, double bill) {
        String sql = "UPDATE customers SET previous_reading = current_reading, current_reading=?, total_bill=? WHERE customer_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newReading);
            ps.setDouble(2, bill);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("✅ Usage recorded and bill updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
