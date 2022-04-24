package yoav.Writers.and.books.clr;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yoav.Writers.and.books.beans.Author;
import yoav.Writers.and.books.beans.Book;
import yoav.Writers.and.books.repositories.AuthorRepository;
import yoav.Writers.and.books.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Test1 implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder()
                .name("Harry Potter 1")
                .year(1997)
                .build();
        Book book2 = Book.builder()
                .name("Harry Potter 2")
                .year(1998)
                .build();
        Book book3= Book.builder()
                .name("The Lord of the Rings 1")
                .year(1954)
                .build();
        Book book4 = Book.builder()
                .name("The Lord of the Rings 2")
                .year(1954)
                .build();
        Author author1 = Author.builder()
                .name("J.K Rolling")
                .weight(70)
                .books(List.of(book1,book2))
                .build();
        Author author2 = Author.builder()
                .name("J.R.R. Tolkien")
                .weight(80)
                .books(List.of(book3,book4))
                .build();
        List<Book> books = new ArrayList<>(List.of(book1, book2, book3, book4));
        List<Author>authors = new ArrayList<>(List.of(author1,author2));
        bookRepository.saveAll(books);
        authorRepository.saveAll(authors);
//        authorRepository.deleteById(1);
//        System.out.println(bookRepository.findAvgYearsByAuthor(1));

    }
}
