package p02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	//接続情報の設定
	private String url = "jdbc:postgresql:canon_db"; //接続するDB名
	private String user = "postgres"; //ユーザ名
	private String pass = "himitu"; //パスワード
	
	protected Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		return con;
	}
}
