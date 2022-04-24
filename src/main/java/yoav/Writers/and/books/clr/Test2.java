package yoav.Writers.and.books.clr;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import yoav.Writers.and.books.beans.Author;
import yoav.Writers.and.books.configuration.MyRestTemplate;
import yoav.Writers.and.books.service.LibraryService;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(2)
public class Test2 implements CommandLineRunner {
    private final LibraryService libraryService;
    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        Author author = restTemplate.getForObject("http://localhost:8080/library/singleAuthor/1",Author.class);
        System.out.println(author);
        List<Author>authorList = restTemplate.getForObject("http://localhost:8080/library/all",List.class);
        System.out.println(authorList);
        double avg = restTemplate.getForObject("http://localhost:8080/library/AVG",Double.class);
        System.out.println(avg);
        double avgByAuthor = restTemplate.getForObject("http://localhost:8080/library/AVGByAuthor/1",Double.class);
        System.out.println(avgByAuthor);
    }
}
