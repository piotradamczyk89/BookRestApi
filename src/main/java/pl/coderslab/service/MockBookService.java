package pl.coderslab.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pl.coderslab.models.Book;
import pl.coderslab.models.BookError;
import pl.coderslab.models.BookInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class MockBookService {

    private List<BookInterface> list = new ArrayList<>();

    public MockBookService() {
        list.add(new Book(5l, "1421641943", "Siema", "Piotr Adamczyk", "OMEGA", "life way"));
        list.add(new Book(7l, "2421641943", "Mucha nie siada", "Anna Grabowiecka", "OMEGA", "life way"));
        list.add(new Book(3l, "3421641943", "Wawrzyniec", "Łukasz Konera", "OMEGA", "life way"));
        list.add(new Book(4l, "4421641943", "Mokka", "Martyna Adamczyk", "OMEGA", "life way"));
        list.add(new Book(1l, "5421641943", "Jak robic córki", "Michał Dyrkacz", "POZNAC", "life way"));
    }

    public List<BookInterface> bookList() {
        return list.stream().sorted().collect(Collectors.toList());
    }

    public BookInterface getBook(Long id) {
        return list.stream().filter(it -> it.getId() == id).findFirst().orElse(new BookError()); //rzucic wyjatek
    }

    public boolean delete(Long id) {
      return list.removeIf(it->it.getId().equals(id));
    }

    public void update(Book book) {
        boolean isBook = false;
        for (BookInterface bookInterface : list) {
            if (bookInterface.getId().equals(book.getId())) {
                list.remove(bookInterface);
                list.add(book);
                isBook = true;
                break;
            }
        }
        if (!isBook) {
            long id = list.stream().map(it -> it.getId()).max(Comparator.comparing(Long::valueOf)).get() + 1;
            book.setId(id);
            list.add(book);
        }
    }
}
