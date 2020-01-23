class Sale {

	
	private int employeeId;
	private int cakeId;
	private int amountSale;
	private Date saleDate;

	
	public Sale(int employeeId, int cakeId, int amountSale, Date saleDate) {
		this.employeeId = employeeId;
		this.cakeId = cakeId;
		this.amountSale = amountSale;
		this.saleDate = saleDate;
	}

	// ID продавца
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}	

	// ID Проданных тортов
	public int cakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}

	// Количество проданных тортов
	public int amountSale() {
		return amountSale;
	}

	public void setAmountSale(int amountSale) {
		this.amountSale = amountSale;
	}
	// Дата продажи
	public Date saleDate() {
		return saleDate;	
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;	
	}
}
