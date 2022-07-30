package speedit.bookplate.scrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.scrap.entity.Scrap;

import java.util.Optional;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {
}
