package pl.coderslab.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequestMapping("/books")
public class BookControler {


        @RequestMapping("/helloBook")

        public Book helloBook() {

            return new Book(1L, "9788324631766", "Thinking in Java","Bruce Eckel", "Helion", "programming");

        }

    }

