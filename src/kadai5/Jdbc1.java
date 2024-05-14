package kadai5;

import java.util.List;

import p02.DAOException;

public class Jdbc1 {

	public static void main(String[] args) {
		//MemberDAOのインスタンスを生成
		MemberDAO dao = new MemberDAO();
		
		List<Member> members = null;
		
		try {
			members = dao.findAllOrderByAgeAsc();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		for (Member m : members) {
			int code = m.getCode();
			String name = m.getName();
			int age = m.getAge();
			String tel = m.getTel();
			
			System.out.println(code + ":" + name + ":" + age + ":" + tel);
		}
	}

}
