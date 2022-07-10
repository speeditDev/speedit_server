package speedit.bookplate.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speedit.bookplate.user.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByNickname(String nickname);
    boolean existsByNickname(String name);
}
