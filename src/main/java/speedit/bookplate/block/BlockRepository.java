package speedit.bookplate.block;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speedit.bookplate.block.entity.Block;
import speedit.bookplate.user.entity.User;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block,Long> {

    List<Block> findByMemberUser(User user);

}
