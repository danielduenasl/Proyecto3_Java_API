package miumg.edu.gt.Project3.Models;


public class User {

	private int idUser;
	private String userName;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public User(int idUser, String userName) {
		super();
		this.idUser = idUser;
		this.userName = userName;
	}
	
	public User() {
		super();
	}
	
	
}
