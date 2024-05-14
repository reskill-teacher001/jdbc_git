package p02;

public class Sample04 {

	public static void main(String[] args) {
		String id = "07";
		String name = "田中";
		int age = 28;
		
		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();
		
		boolean check = false;
		
		try {
			check = dao.insert(id, name, age);
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
