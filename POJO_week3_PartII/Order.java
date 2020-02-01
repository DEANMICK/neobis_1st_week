import java.util.Date;
class Order{
	
	private int orderId;
	private int clientId;
	private int cakeId;
	private Date orderDate;
	private boolean pay;

		
	public Order(int orderId, int clientId,int cakeId, Date orderDate, boolean pay) {
		this.orderId = orderId;
		this.clientId = clientId;
		this.cakeId = cakeId;
		this.orderDate = orderDate;
		this.pay = pay;
	}

	// ID заказа
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}	

	// ID заказчика
	public int getClientId() {
		return clientId;		
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;		
	}

	// ID торта заказ
	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}

	// Дата заказа
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	// Подтверждение об оплате
	public boolean pay() {
		return pay;
	}
	
	public void setpay(boolean pay) {
		this.pay = pay;
	}
}
