package in.suryaumapathy.projects.collage_admission.dto;

public class StudentDepartmentDetailsDto {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "StudentDepartmentDetailsDto { id=" + id + ", departmentId=" + departmentId + ", name=" + name + " }";
	}


	private int id;
	private int departmentId;
	private String name;
	
	
	
}
