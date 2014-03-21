package app.shared.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity(name="BOOK")
public class Book implements Serializable {
	private static final long serialVersionUID = 6628654835546550164L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;

	@Size (max=100, message="Maximal 10 characters!")
	@Column(nullable = false, name="AUTHOR")
	private String author;

	@Size (max=30, message="Maximal 30 characters!")
	@Column(nullable = false, name="TITLE")
	private String title;

	@Max(value = 2100, message = "To far in the future!")
	@Min(value = 1400, message = "To far in the past!")
	@Column(nullable = false, name="PUBLICATION_YEAR")
	private int publicationYear;

	@Column(name="RENTAL_EXPIRY_DATE")
	private Date rentalExpiryDate;

	@ManyToOne
	private Reader currentReader;
	
	public Book() {
	}

	public Book(Long id, String author, String title) {
		this.id = id;
		this.author = author;
		this.title = title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Reader getCurrentReader() {
		return currentReader;
	}

	public void setCurrentReader(Reader currentReader) {
		this.currentReader = currentReader;
	}

	public Date getRentalExpiryDate() {
		return rentalExpiryDate;
	}

	public void setRentalExpiryDate(Date rentalExpiryDate) {
		this.rentalExpiryDate = rentalExpiryDate;
	}
}
