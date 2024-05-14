package kadai5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import p02.DAOException;

public class MemberDAO extends DAO {
	//全件検索メソッド
	public List<Member> findAllOrderByAgeAsc() throws DAOException {
		List<Member> members = new ArrayList<>();

		String sql = "SELECT code, name, age, tel FROM members ";
		sql += "ORDER BY age ASC";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //codeの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age"); //ageの列のデータを取得
				String tel = rs.getString("tel"); //telの列のデータを取得

				members.add(new Member(code, name, age, tel));
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return members;
	}

	//あいまい検索メソッド
	public List<Member> findByNameLike(String key) throws DAOException {
		List<Member> members = new ArrayList<>();

		String sql = "SELECT code, name, age, tel FROM members ";
		sql += "WHERE name LIKE ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //codeの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age"); //ageの列のデータを取得
				String tel = rs.getString("tel"); //telの列のデータを取得

				members.add(new Member(code, name, age, tel));
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return members;
	}

}
