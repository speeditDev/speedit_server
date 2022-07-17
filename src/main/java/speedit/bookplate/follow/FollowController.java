package speedit.bookplate.follow;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.follow.dto.Follow;
import speedit.bookplate.utils.JwtService;

@Controller
@AllArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private FollowService followService;

    private JwtService jwtService;


    @PostMapping("/create")
    @ResponseBody
    public BaseResponse<String> createFollow(@RequestBody Follow follow){
        try{
            long followerId=jwtService.getUserIdx();
            followService.createFollow(followerId,follow.getFollowedId());
            return new BaseResponse<>("팔로우 등록에 성공하였습니다");
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public BaseResponse<String> deleteFollow(@RequestBody Follow follow){
        try{
            long followerId=jwtService.getUserIdx();
            followService.deleteFollow(followerId,follow.getFollowedId());
            return new BaseResponse<>("팔로우 취소에 성공하였습니다");
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
