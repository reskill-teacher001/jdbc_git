package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample02 {

	public static void main(String[] args) {
		//JDBCドライバの登録
		//JDBCドライバマネージャーに使用するDBの種類を教える
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
		
		String sql = "SELECT id, name, age FROM users";
		
		//データベースへの接続
		try {
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = DriverManager.getConnection(url, user, pass);
			
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			
			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();
			
			while(rs.next() == true) { //レコードがある回数繰り返す
				//レコードの列のデータを取得する
//				String id = rs.getString("id"); //idの列のデータを取得
//				String name = rs.getString("name"); //nameの列のデータを取得
//				int age = rs.getInt("age"); //ageの列のデータを取得
				String id = rs.getString(1); //idの列のデータを取得
				String name = rs.getString(2); //nameの列のデータを取得
				int age = rs.getInt(3); //ageの列のデータを取得
				
				System.out.println(id + "\t" + name + "\t" + age);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
