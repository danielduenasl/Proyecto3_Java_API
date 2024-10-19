package miumg.edu.gt.Project3.Models;

public class testModel {

	private int Id;
	private String Name;
	private boolean Status;
	
	public testModel() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public testModel(int id, String name, boolean status) {
		super();
		Id = id;
		Name = name;
		Status = status;
	}
	
	
}
