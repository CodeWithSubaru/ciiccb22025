package jobsheet.job_sheet_2_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static final String URL = Constant.URL;
	private static final String USERNAME = Constant.USER;
	private static final String PASSWORD = Constant.PASSWORD;
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
