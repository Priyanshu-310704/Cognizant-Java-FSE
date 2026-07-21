package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        runXmlConfiguredApplication();
        runAnnotationConfiguredApplication();
    }

    private static void runXmlConfiguredApplication() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            BookService bookService = context.getBean("bookService", BookService.class);
            bookService.addBook("Clean Code");
            bookService.addBook("Effective Java");
            System.out.println("XML configured books: " + bookService.getAllBooks());
        }
    }

    private static void runAnnotationConfiguredApplication() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationContext.xml")) {
            BookService bookService = context.getBean(BookService.class);
            bookService.addBook("Spring in Action");
            System.out.println("Annotation configured books: " + bookService.getAllBooks());
        }
    }
}
