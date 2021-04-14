package pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Embeddable
public class AdharCard {
	@Column(name="card_no",unique = true)
	private String cardNumber;
	@Column(name="created_on")
	private LocalDate createdOn;

	public AdharCard() {
		// TODO Auto-generated constructor stub
	}

	public AdharCard(String cardNumber, LocalDate createdOn) {
		super();
		this.cardNumber = cardNumber;
		this.createdOn = createdOn;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", createdOn=" + createdOn + "]";
	}

}
