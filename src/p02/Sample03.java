package p02;

import java.util.List;

public class Sample03 {

	public static void main(String[] args) {
		
		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();
		
		//findAllメソッドの呼び出し
		List<User> users = null;
		
		try {
			users = dao.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		for (User u : users) {
			String id = u.getId();
			String name = u.getName();
			int age = u.getAge();

			System.out.println(id + "\t" + name + "\t" + age);
		}
	}

}
