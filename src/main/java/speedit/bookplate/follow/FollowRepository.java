package speedit.bookplate.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speedit.bookplate.follow.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {

}
