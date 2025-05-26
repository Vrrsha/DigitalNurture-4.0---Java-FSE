import java.sql.*;

public class MoneyTransfer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank";
        try (Connection conn = DriverManager.getConnection(url, "root", "password")) {
            conn.setAutoCommit(false);

            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
                stmt.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id = 2");

                conn.commit();
                System.out.println("Transaction successful");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transaction failed, rolled back.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
