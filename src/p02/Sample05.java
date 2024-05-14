package p02;

public class Sample05 {

	public static void main(String[] args) {
		
		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();
		
		boolean check = false;
		
		try {
			check = dao.insert(new User("08", "薄井", 29));
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
