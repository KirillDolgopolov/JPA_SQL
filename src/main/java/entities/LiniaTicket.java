package entities;

public class LiniaTicket {
	
	private Long id;
	private Long producteId;
	private Long ticketId;
	
	public LiniaTicket() {
		
	}
	
	public LiniaTicket(Long id, Long producteId, Long ticketId) {
		
		this.id = id;
		this.producteId = producteId;
		this.ticketId = ticketId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProducteId() {
		return producteId;
	}

	public void setProducteId(Long producteId) {
		this.producteId = producteId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	
}
