package pl.coderslab.models;


import lombok.Data;

@Data
public class BookDto {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;


    public BookDto() {
    }

    public Book map() {
        Book book = new Book();
        book.setId(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
        return book;
    }
}
