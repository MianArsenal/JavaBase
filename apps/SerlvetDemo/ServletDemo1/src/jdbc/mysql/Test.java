package jdbc.mysql;

import java.sql.*;

public class Test {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?" + "user=root&password=123456");
            System.out.println("Connected!");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user;");
            ResultSet resultSet = preparedStatement.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                    if ((i == 2) && (resultSet.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
