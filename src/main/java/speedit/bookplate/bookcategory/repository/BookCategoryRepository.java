package speedit.bookplate.bookcategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.bookcategory.entity.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>{

}
