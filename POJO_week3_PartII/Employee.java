class Employee {
	

	private int employeeId;
	private String employeeName;
	private String employeeSurname;
	private String employeePhone;
	private String employeeAddress;
	private short employeeAge;
	private double employeeSalary;
	private enum employeePosition;
	

	public Employee(int employeeId, String employeeName, String employeeSurname, String employeePhone, String employeeAddress, short employeeAge, double employeeSalary, enum employeePosition) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSurname = employeeSurname;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
		this.employeeAge = employeeAge;
		this.employeeSalary = employeeSalary;
		this.employeePosition = employeePosition;
 	} 

	// ID сотрудника
	public int getEmployee() {
		return employeeId;
	}
	
	public void setEmployee(int employeeId) {
		this.employeeId = employeeId;
	}	
	
	// Имя сотрудника
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	// Фамилия Сотрудника
	public String getEmployeeSurname() {
		return employeeSurname;
	}

	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	// Номер телефона сотрудника
	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	// Адрес сотрудника
	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}	
	
	// Возраст сотрудника
	public short getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(short employeeAge) {
		this.employeeAge = employeeAge;
	}

	// Зарплата сотрудника
	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	// Должность сотрудника
	public enum getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(enum employeePosition) {
		this.employeePosition = employeePosition;
	}
}
