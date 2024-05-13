package kadai4add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc9 {

	public static void main(String[] args) {
		//JDBCドライバの登録
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが登録されていません");
			e.printStackTrace();
		}
		
		//接続情報の設定
		String url = "jdbc:postgresql:canon_db"; //接続するDB名
		String user = "postgres";                //ユーザ名
		String pass = "himitu";                  //パスワード
		
		String sql = "SELECT CASE ";
		sql += "WHEN 20 <= age AND age < 30 THEN '２０代' ";
		sql += "WHEN 30 <= age AND age < 40 THEN '３０代' ";
		sql += "WHEN 40 <= age AND age < 50 THEN '４０代' ";
		sql += "WHEN 50 <= age AND age < 60 THEN '５０代' ";
		sql += "END AS era, ";
		sql += "count(*) AS count ";
		sql += "FROM emp ";
		sql += "GROUP BY era ";
		sql += "ORDER BY era";
		
		//データベースへの接続
		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = DriverManager.getConnection(url, user, pass);
		) {			
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
				
			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();
			
			while (rs.next() == true) { //レコードがあれば
				//レコードの列のデータを取得する
				String era = rs.getString("era"); //年代を取得
				int count = rs.getInt("count"); //年代別人数を取得
				
				System.out.println(era + "：" + count + "人");
			}
			
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
