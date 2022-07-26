package speedit.bookplate.block;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.block.dto.BlockDto;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.user.repositroy.UserRepository;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.utils.JwtService;

@Controller
@AllArgsConstructor
@RequestMapping("/block")
public class BlockController {

    private final BlockService blockService;

    private final JwtService jwtService;

    private final UserRepository userRepository;

    @PostMapping("")
    @ResponseBody
    public BaseResponse<String> createBlock(@RequestBody BlockDto blockDto){
        try{
            long mainUserIdx=jwtService.getUserIdx();
            User user1=userRepository.findByUserIdx(mainUserIdx);
            if (blockService.testBlock(user1,blockDto.getTargetIdx())) {
                return new BaseResponse<String>("이미 차단된 유저입니다.");
            }else{
                blockService.createBlock(mainUserIdx,blockDto.getTargetIdx());
                return new BaseResponse<>("차단에 성공하였습니다.");
            }
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
