package kadai4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc3 {

	public static void main(String[] args) {
		//キーボード入力のおまじない
		Scanner scan = new Scanner(System.in);
		
		System.out.print("コードを入力してください：");
		int _code = scan.nextInt();
		
		System.out.print("名前を入力してください：");
		String _name = scan.next();
		
		System.out.print("年齢を入力してください：");
		int _age = scan.nextInt();
		
		System.out.print("電話番号を入力してください：");
		String _tel = scan.next();
		
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
		
		String sql = "INSERT INTO emp VALUES(?, ?, ?, ?)";
		
		//データベースへの接続
		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = DriverManager.getConnection(url, user, pass);
		) {			
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
				
			//プレースホルダの部分に値を設定する
			ps.setInt(1, _code);
			ps.setString(2, _name);
			ps.setInt(3, _age);
			ps.setString(4, _tel);
			
			//SQLを実行して結果を取得する
			int kazu = ps.executeUpdate();
			
			if (kazu == 1) {
				System.out.println(kazu + "件、レコードを登録しました。");
			}
			
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
