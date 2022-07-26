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
    public void createBlock(long mainUserIdx,long targetUserIdx){
        User mainUser=userRepository.findByUserIdx(mainUserIdx);
        User targetUser=userRepository.findByUserIdx(targetUserIdx);
        Block.createBlock(mainUser,targetUser);
    }

    public boolean testBlock(User memberUser,long targetIdx){
        User testUser=blockRepository.findByMemberUser(memberUser).getMemberUser();
        long testIdx=blockRepository.findByMemberUser(memberUser).getTargetUser().getUserIdx();
        if(testIdx==targetIdx && testUser==memberUser){
            return true;
        }else{
            return false;
        }
    }

}
