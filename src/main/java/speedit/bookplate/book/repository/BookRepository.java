package speedit.bookplate.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speedit.bookplate.book.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
        Optional<Book> findById(Long id);
        Optional<Book> findByBookNameContains(String searchValue);
}
