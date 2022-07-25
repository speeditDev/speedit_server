package speedit.bookplate.block;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.block.entity.Block;
import speedit.bookplate.user.repositroy.UserRepository;
import speedit.bookplate.user.entity.User;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BlockService {

    private final UserRepository userRepository;

    private final BlockRepository blockRepository;

    @Transactional
    public void createBlock(long memberUserIdx,long targetUserIdx){
        User memberUser=userRepository.findByUserIdx(memberUserIdx);
        User targetUser=userRepository.findByUserIdx(targetUserIdx);
        Block.createBlock(memberUser,targetUser);
    }

}
