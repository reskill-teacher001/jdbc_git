package p00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample01 {

	public static void main(String[] args) {
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ドライバが登録されていません");
			e.printStackTrace();
		}
		
		//データベース接続情報
		String url = "jdbc:postgresql:sample_db";
		String user = "postgres";
		String pass = "himitu";
		
		//実行のSQL文
		String sql = "SELECT id, name FROM Members";		
		
		try {
			//データベースへの接続
			Connection con = DriverManager.getConnection(url, user, pass);
			
			//SQL実行の準備
			PreparedStatement ps = con.prepareStatement(sql);
			
			//SQL実行結果の取得
			ResultSet rs = ps.executeQuery();
			
			//結果の表示
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				System.out.println(id + "\t" + name);
			}
			
			//リソースのクローズ
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("データベース関連エラーです");
			e.printStackTrace();
		}
		
	}

}
