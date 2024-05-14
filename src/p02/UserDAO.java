package p02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {

	//単一検索メソッド（idによる検索）
	public User findById(String _id) throws DAOException {
		User u = null;

		String sql = "SELECT id, name, age FROM users WHERE id = ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//プレースホルダの部分に値を設定する
			ps.setString(1, _id);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				String id = rs.getString("id"); //idの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age"); //ageの列のデータを取得

				u = new User(id, name, age);
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return u;
	}
	
	//全件検索メソッド
	public List<User> findAll() throws DAOException {
		List<User> users = new ArrayList<>();

		String sql = "SELECT id, name, age FROM users";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				String id = rs.getString("id"); //idの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age"); //ageの列のデータを取得

//				User u = new User(id, name, age);
//				users.add(u);
				
				users.add(new User(id, name, age));
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return users;
	}
	
	//登録メソッド
	public boolean insert(String id, String name, int age) throws DAOException {
		boolean check = false;

		String sql = "INSERT INTO users VALUES(?, ?, ?)";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);

			//SQLを実行して結果を取得する
			int row = ps.executeUpdate();
			
			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return check;
	}
	
	public boolean insert(User u) throws DAOException {
		boolean check = false;
		
		String id = u.getId();
		String name = u.getName();
		int age = u.getAge();

		String sql = "INSERT INTO users VALUES(?, ?, ?)";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);

			//SQLを実行して結果を取得する
			int row = ps.executeUpdate();
			
			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return check;
	}
	
	//変更メソッド
	public boolean update(String id, String name, int age) throws DAOException {
		boolean check = false;

		String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, id);

			//SQLを実行して結果を取得する
			int row = ps.executeUpdate();
			
			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return check;
	}

}
