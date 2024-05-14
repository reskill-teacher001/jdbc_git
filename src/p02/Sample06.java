package p02;

public class Sample06 {

	public static void main(String[] args) {
		String id = "06";
		String name = "斎藤";
		int age = 20;
		
		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();
		
		boolean check = false;
		
		try {
			check = dao.update(id, name, age);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (check == true) {
			System.out.println("登録成功");
		} else {
			System.out.println("登録失敗");
		}
	}

}
