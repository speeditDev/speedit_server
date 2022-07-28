package speedit.bookplate.follow;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.user.entity.User;

import java.util.List;


@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {

    List<Follow> findByFollower(User user);

    List<Follow> findByFollowed(User user);

}
