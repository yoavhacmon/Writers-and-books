package yoav.Writers.and.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yoav.Writers.and.books.beans.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book>findByYearBetween(int start, int end);

    @Query(value = "SELECT AVG (year) FROM `Writers-and-books`.`books`", nativeQuery = true)
    double findAvgYears();

    @Query(value = "SELECT AVG (year) FROM `Writers-and-books`.`books` WHERE id=any (SELECT books_id FROM `Writers-and-books`.authors_books WHERE author_id = ?1)", nativeQuery = true)
    double findAvgYearsByAuthor(int author_id);
}




