package app.shared.service;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class BookSearchCriteria implements Serializable {

	private static final long serialVersionUID = -5435813338532725622L;

	@Size (max=30, message="Maximal 30 characters!")
	private String title;

	@Size (max=10, message="Maximal 10 characters!")
	private String author;
	
	@Max(value = 2100, message = "To far in the future!")
	@Min(value = 1400, message = "To far in the past!")
	private Integer publicationYear;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof BookSearchCriteria)) {
			return false;
		}

		BookSearchCriteria other = (BookSearchCriteria) obj;

		boolean equals = true;

		equals = equals
				&& (null != title ? title.equals(other.title)
						: null == other.title);
		equals = equals
				&& (null != publicationYear ? publicationYear
						.equals(other.publicationYear)
						: null == other.publicationYear);
		equals = equals
				&& (null != author ? author.equals(other.author)
						: null == other.author);

		return equals;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return (title + author + publicationYear).hashCode();
	}
}
