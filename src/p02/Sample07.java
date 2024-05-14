package p02;

public class Sample07 {

	public static void main(String[] args) {
		String id = "03";
		
		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();
		
		boolean check = false;
		
		try {
			check = dao.delete(id);
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
