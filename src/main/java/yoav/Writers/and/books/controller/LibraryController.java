package yoav.Writers.and.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoav.Writers.and.books.Exceptions.LibraryCustomException;
import yoav.Writers.and.books.beans.Author;
import yoav.Writers.and.books.service.LibraryService;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    //create
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addAuthor(@RequestBody Author author){
        libraryService.addAuthor(author);
    }
    //read
    @GetMapping("/all")
    public ResponseEntity<?> getAllAuthors(){
        return new ResponseEntity<>(libraryService.getAllAuthors(), HttpStatus.OK);
    }
    @GetMapping("/singleAuthor/{id}")
    public ResponseEntity<?> getSingleAuthor(@PathVariable int id) throws LibraryCustomException {
        return new ResponseEntity<>(libraryService.findAuthor(id), HttpStatus.OK);
    }
    @GetMapping("/byYears/{start}/{end}")
    public ResponseEntity<?>getBooksByYears(@PathVariable int start, @PathVariable int end) throws LibraryCustomException {
        return new ResponseEntity<>(libraryService.findByYears(start, end),HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAuthor(@PathVariable int id) throws LibraryCustomException {
        libraryService.deleteAuthor(id);
    }

    //other func
    @GetMapping("/AVG")
    public ResponseEntity<?>getAvg(){
        return new ResponseEntity<>(libraryService.findAvgYears(),HttpStatus.OK);
    }
    @GetMapping("/AVGByAuthor/{id}")
    public ResponseEntity<?>getAvg(@PathVariable int id) throws LibraryCustomException {
        return new ResponseEntity<>(libraryService.findAvgYearsByAuthor(id),HttpStatus.OK);
    }
}
