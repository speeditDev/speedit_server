package speedit.bookplate.user.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import speedit.bookplate.user.entity.enumTypes.UserStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByNicknameAndType(String nickname,OAuthType type);

    boolean existsByNickname(String name);

    User findByUserIdx(Long userIdx);

    @Modifying
    @Query("UPDATE User u SET u.status=:status WHERE u.userIdx=:userIdx")
    void deleteUser(Long userIdx, UserStatus status);

    @Query("select u from User u left join fetch u.followed_follows WHERE u.userIdx=:followIdx")
    List<User> findFollowedByFollowIdx(Long followIdx);

}
