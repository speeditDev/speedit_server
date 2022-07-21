package speedit.bookplate.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import speedit.bookplate.user.entity.enumTypes.UserStatus;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByNickname(String nickname);

    Optional<User> findByNicknameAndType(String nickname,OAuthType type);

    boolean existsByNickname(String name);

    User findByUserIdx(Long userIdx);

    @Modifying
    @Query("UPDATE User u SET u.status=:status WHERE u.userIdx=:userIdx")
    void updateInactiveUser(Long userIdx, UserStatus status);

    @Modifying
    @Query("")
    void updateUserProfile();

}
