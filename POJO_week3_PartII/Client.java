class Client {
	
	private int clientId;
	private String clientName;
	private String clientPhone;
	private String clientMail;
	
	public Client(int clientId, String clientName, String clientPhone, String clientMail) {
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.clientMail = clientMail;
	}
	
	// ID клиента
 	public int getclientId() {
		return clientId;
	}
 
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	// Имя клиента
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	// Телефонный номер
	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	// Почтовый адрес email
	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

}
