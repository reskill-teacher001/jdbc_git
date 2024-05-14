package p02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample01 {

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
		
		String _id = "01";
		String sql = "SELECT id, name, age FROM users WHERE id = ?";
		
		//データベースへの接続
		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = DriverManager.getConnection(url, user, pass);
		) {			
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			
			//プレースホルダの部分に値を設定する
			ps.setString(1, _id);
				
			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();
			
			User u = null;
			
			if (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				String id = rs.getString("id"); //idの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age"); //ageの列のデータを取得
				
				u = new User(id, name, age);
			}
			
			if (u != null) {
				String __id = u.getId();
				String _name = u.getName();
				int _age = u.getAge();
				
				System.out.println(__id + "\t" + _name + "\t" + _age);
			} else {
				System.out.println("指定したIDに該当するレコードがありません");
			}
			
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
