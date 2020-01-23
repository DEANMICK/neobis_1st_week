class Cake {

    private int cakeId;
    private String cakeName;
    private enum cakeSize;
	private Date cakeData;
	private enum cakeFilling;
	private int employeeId;
    private double cakePrice;

		
	public Cake(int cakeId, String cakeName, enum cakeSize, Date cakeData, enum cakeFilling, int employeeId, double cakePrice) {
		this.cakeId = cakeId;
 		this.cakeName = cakeName;
        this.cakeSize = cakeSize;
		this.cakeData = cakeData;
		this.cakeFilling = cakeFilling;
		this.employeeId = employeeId;
        this.cakePrice = cakePrice;
	}
	


    // Номер торта
    public int getCakeId() {
        return cakeId;
    }
	
	public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    // Наименование торта
    public String getCakeName() {
        return cakeName;
    }

	public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    // Размер торта
    public enum getCakeSize() {
        return cakeSize;
    }

	public void setCakeSize(enum cakeSize) {
        this.cakeSize = cakeSize;
    }	

	// Дата изготовления
	public Date getCakeData() {
		return cakeData;
	}
	
	public void setCakeData(Date cakeData) {
		this.cakeData = cakeData;
	}	
	
	// Начинка торта
	public enum getCakeFilling() {
		return cakeFilling;
	}

	public void setCakeFilling(enum cakeFilling) {
		this.cakeFilling = cakeFilling;
	}

	// ID повара(пекаря)
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

    // Цена торта
    public double getCakePrice() {
        return cakePrice;
    }
	
	public void setCakePrice(double cakePrice) {
        this.cakePrice = cakePrice;
    }
}
