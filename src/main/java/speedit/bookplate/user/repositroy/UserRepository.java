package speedit.bookplate.user.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import speedit.bookplate.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}
