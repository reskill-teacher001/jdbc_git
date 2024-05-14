package kadai5;

public class Member {
	//フィールド
	private int code;    //コード
	private String name; //名前
	private int age;     //年齢
	private String tel;  //電話番号
	
	//コンストラクタ
	public Member(int code, String name, int age, String tel) {
		this.code = code;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	//セッタ＆ゲッタ
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
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
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
