package team2.book;

import java.util.Objects;

public class BookVO {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPub;
    private String bookYear;
    private String bookOrRen;
    private String bookOrDel;
    private String bookOutdate;

    public BookVO() {
	}
    
	public BookVO(String bookName, String bookAuthor, String bookPub, String bookYear) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPub = bookPub;
		this.bookYear = bookYear;
	}

	public BookVO(int bookId, String bookName, String bookAuthor, String bookPub, String bookYear, String bookOrRen,
			String bookOrDel, String bookOutdate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPub = bookPub;
		this.bookYear = bookYear;
		this.bookOrRen = bookOrRen;
		this.bookOrDel = bookOrDel;
		this.bookOutdate = bookOutdate;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPub() {
		return bookPub;
	}

	public void setBookPub(String bookPub) {
		this.bookPub = bookPub;
	}

	public String getBookYear() {
		return bookYear;
	}

	public void setBookYear(String bookYear) {
		this.bookYear = bookYear;
	}

	public String getBookOrRen() {
		return bookOrRen;
	}

	public void setBookOrRen(String bookOrRen) {
		this.bookOrRen = bookOrRen;
	}

	public String getBookOrDel() {
		return bookOrDel;
	}

	public void setBookOrDel(String bookOrDel) {
		this.bookOrDel = bookOrDel;
	}

	public String getBookOutdate() {
		return bookOutdate;
	}

	public void setBookOutdate(String bookOutdate) {
		this.bookOutdate = bookOutdate;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookVO{");
        sb.append("bookId=").append(bookId);
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", bookAuthor='").append(bookAuthor).append('\'');
        sb.append(", bookPub=").append(bookPub);
        sb.append(", bookYear=").append(bookYear);
        sb.append(", bookOrRen=").append(bookOrRen);
        sb.append(", bookOrDel=").append(bookOrDel);
        sb.append(", bookOutdate=").append(bookOutdate);
        sb.append('}');
        return sb.toString();
    }
}
