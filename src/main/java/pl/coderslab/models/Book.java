package pl.coderslab.models;


import lombok.Data;

@Data
public class Book implements BookInterface, Comparable <BookInterface> {


    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

    public Book(Long id, String isbn, String title, String author, String publisher, String type) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
    }

    public Book() {
    }

    @Override
    public int compareTo(BookInterface o) {
        if (this.id == o.getId()) {
            return 0;
        } else if ((this.id > o.getId())) {
            return 1;
        } else {
            return -1;
        }
    }


    @Override
    public Long getId() {
        return id;
    }
}
