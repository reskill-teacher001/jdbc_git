package kadai5;

import java.util.List;
import java.util.Scanner;

import p02.DAOException;

public class Jdbc2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("名前を入力してください：");
		String key = scan.next();

		//MemberDAOのインスタンスを生成
		MemberDAO dao = new MemberDAO();
		
		List<Member> members = null;
		
		try {
			members = dao.findByNameLike(key);
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
