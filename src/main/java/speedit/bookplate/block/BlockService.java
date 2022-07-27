package speedit.bookplate.block;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.block.entity.Block;
import speedit.bookplate.user.repositroy.UserRepository;
import speedit.bookplate.user.entity.User;

import java.util.ArrayList;

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
        Block mainBlock = Block.createBlock(mainUser, targetUser);
        blockRepository.save(mainBlock);
    }

    public boolean checkBlock(User memberUser,long targetIdx){
        ArrayList<Long> target=new ArrayList<Long>();
        for(Block block:blockRepository.findByMemberUser(memberUser)){
            target.add(block.getTargetUser().getUserIdx());
        }
        if(target.contains(targetIdx)){
            return true;
        }else{
            return false;
        }
    }
}
