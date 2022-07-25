package speedit.bookplate.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speedit.bookplate.feed.entity.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long> {
//    Optional<Feed> findById(Long id);
}
