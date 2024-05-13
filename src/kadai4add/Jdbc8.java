package kadai4add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc8 {

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
		
		String sql = "SELECT min(age) AS min, max(age) AS max, avg(age) AS avg FROM emp";
		
		//データベースへの接続
		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = DriverManager.getConnection(url, user, pass);
		) {			
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
				
			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();
			
			if (rs.next() == true) { //レコードがあれば
				//レコードの列のデータを取得する
				int min = rs.getInt("min"); //最小年齢を取得
				int max = rs.getInt("max"); //最高年齢を取得
				double avg = rs.getDouble("avg"); //平均年齢を取得
				
				System.out.println("年齢の最小は：" + min + "歳");
				System.out.println("年齢の最大は：" + max + "歳");
				System.out.println("年齢の平均は：" + avg + "歳");
			}
			
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
