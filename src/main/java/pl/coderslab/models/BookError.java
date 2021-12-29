package pl.coderslab.models;

import lombok.Data;

@Data
public class BookError implements BookInterface {


    private Long id = 0l;
    private String noBook = "bookNotFind";

    @Override
    public Long getId() {
        return id ;
    }

}
