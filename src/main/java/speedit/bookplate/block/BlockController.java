package speedit.bookplate.block;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import speedit.bookplate.block.dto.BlockDto;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.utils.JwtService;

@Controller
@AllArgsConstructor
@RequestMapping("/block")
public class BlockController {

    private final BlockService blockService;

    private final JwtService jwtService;

    @PostMapping("/create")
    @ResponseBody
    public BaseResponse<String> createBlock(@RequestBody BlockDto blockDto){
        try{
            long memberUserIdx=jwtService.getUserIdx();
            blockService.createBlock(memberUserIdx,blockDto.getTargetIdx());
            return new BaseResponse<>("차단에 성공하였습니다.");
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }

    }




}
