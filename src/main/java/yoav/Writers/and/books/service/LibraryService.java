package yoav.Writers.and.books.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yoav.Writers.and.books.Exceptions.LibraryCustomException;
import yoav.Writers.and.books.beans.Author;
import yoav.Writers.and.books.beans.Book;
import yoav.Writers.and.books.repositories.AuthorRepository;
import yoav.Writers.and.books.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(author);
        bookRepository.saveAll(author.getBooks());
    }

    public void deleteAuthor(int id) throws LibraryCustomException {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
        } else {
            throw new LibraryCustomException("id not exist");
        }
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthor(int id) throws LibraryCustomException {
        if (authorRepository.findById(id).isPresent()) {
            return authorRepository.getById(id);
        } else {
            throw new LibraryCustomException("id not exist");
        }
    }
    public List<Book> findByYears(int start, int end) throws LibraryCustomException {
        if (start<end){
            return bookRepository.findByYearBetween(start, end);
        } else {
            throw new LibraryCustomException("The start time is greater than the end time");
        }
    }
    public double findAvgYears(){
        return bookRepository.findAvgYears();
    }

    public double findAvgYearsByAuthor(int author_id) throws LibraryCustomException {
        if (authorRepository.findById(author_id).isPresent()) {
            return bookRepository.findAvgYearsByAuthor(author_id);
        } else {
            throw new LibraryCustomException();
        }
    }

}
