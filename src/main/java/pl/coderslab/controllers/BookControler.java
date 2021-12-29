package pl.coderslab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.models.Book;
import pl.coderslab.models.BookDto;
import pl.coderslab.models.BookInterface;
import pl.coderslab.models.JsonResponse;
import pl.coderslab.service.MockBookService;

import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookControler {

    private MockBookService mockBookService;

    public BookControler(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<BookInterface> bookList() {
        return mockBookService.bookList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Book addBook(@RequestBody BookDto bookDto) {
        Book book = bookDto.map();
        mockBookService.update(book);
        return book;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Book update(@RequestBody BookDto bookDto) {
        Book book = bookDto.map();
        mockBookService.update(book);
        return book;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResponse deleteBook (@PathVariable Long id) {
        if(mockBookService.delete(id)) {
         return new JsonResponse(HttpStatus.OK,String.format("Object %s successfully removed",id));
        } else {
            return new JsonResponse(HttpStatus.NOT_FOUND,String.format("Object %s not found in DB",id));
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BookInterface bookInfo (@PathVariable Long id) {

        return mockBookService.getBook(id);
    }








}

