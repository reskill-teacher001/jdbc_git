package p02;

public class User {
	//フィールド
	private String id;   //ID
	private String name; //名前
	private int age;     //年齢
	
	//コンストラクタ
	public User(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	//セッタ＆ゲッタ
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
