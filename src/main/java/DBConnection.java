import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static User findUserByName(String username) {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "123456";

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		User userResult = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("成功链接至数据库");

			statement = connection.createStatement();
			String sql = "SELECT * from user_info where username = \'" + username + "\';";
			result = statement.executeQuery(sql);
			System.out.println("SQL执行成功");

			while (result.next()) {
				userResult = new User(result.getString(1), result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
					System.out.println("数据库链接关闭	");
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userResult;
	}
}
