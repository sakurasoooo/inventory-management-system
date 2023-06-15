package Chaoshi;

public class User {             //用户类
	
	private String username;
	private String password;
	private int app;
	private int qiyi;
	private int ban;
	
	public User(String username,String password,int app,int qiyi,int ban)       //构造方法
	{
		this.username=username;
		this.password=password;
		this.app=app;
		this.qiyi=qiyi;
		this.ban=ban;
	}
	                                                        //get/set方法
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getApp() {
		return app;
	}
	public void setApp(int app) {
		this.app = app;
	}
	public int getQiyi() {
		return qiyi;
	}
	public void setQiyi(int qiyi) {
		this.qiyi = qiyi;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}


}
