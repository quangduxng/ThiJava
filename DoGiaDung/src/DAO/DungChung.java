package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public static Connection cn;

	public void KetNoi() {
		try {
			// nap database
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("da xac nhan");
			// ket noi voi csld
			cn = DriverManager.getConnection(
					"jdbc:sqlserver://QUANGDUXNG:1433;databaseName=Giay;username=sa;password=1234");
			System.out.println("da xac nhan csdl");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}