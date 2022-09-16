package team2.returnbook;

import java.sql.Date;

public class ReturnBookVO {
	
	private int bookOrRent;
	private int rentNo;
	private int bookId;
	private Date returnDate;
	
	
	public ReturnBookVO(int bookId) {
		this.bookId = bookId;
	}

	public ReturnBookVO(int bookOrRent, int rentNo, int bookId, Date returnDate) {
		
		this.bookOrRent = bookOrRent;
		this.rentNo = rentNo;
		this.bookId = bookId;
		this.returnDate = returnDate;
	}

	public ReturnBookVO(int bookOrRent, Date returnDate) {
	
		this.bookOrRent = bookOrRent;
		this.returnDate = returnDate;
	}


	public int getBookOrRent() {
		return bookOrRent;
	}


	public void setBookOrRent(int bookOrRent) {
		this.bookOrRent = bookOrRent;
	}


	public int getRentNo() {
		return rentNo;
	}


	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}


	public int getBookId() {
	
		return this.bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("BookVO{");
	        sb.append("bookOrRent=").append(bookOrRent);
	        sb.append(", rentNo='").append(rentNo).append('\'');
	        sb.append(", bookId='").append(bookId).append('\'');
	        sb.append(", returnDate=").append(returnDate);
	        sb.append('}');
	        return sb.toString();
	    }

}
