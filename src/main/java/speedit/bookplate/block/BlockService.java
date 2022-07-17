package speedit.bookplate.block;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import speedit.bookplate.block.entity.Block;
import speedit.bookplate.user.UserRepository;
import speedit.bookplate.user.entity.User;

@Service
@AllArgsConstructor
public class BlockService {

    private final UserRepository userRepository;

    private final BlockRepository blockRepository;

    public void createBlock(long memberUserIdx,long targetUserIdx){
        User memberUser=userRepository.findByUserIdx(memberUserIdx);
        User targetUser=userRepository.findByUserIdx(targetUserIdx);
        Block.createBlock(memberUser,targetUser);
    }

}
