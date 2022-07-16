package speedit.bookplate.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.utils.JwtService;

@Controller
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @Autowired
    private JwtService jwtService;

    public FollowController(FollowService followService, JwtService jwtService) {
        this.followService = followService;
        this.jwtService = jwtService;
    }

    @PostMapping("/save")
    @ResponseBody
    public BaseResponse<String> saveFollow(@RequestBody long follwedId){
        try{
            long followerId=jwtService.getUserIdx();
            followService.createFollow(followerId,follwedId);
            return new BaseResponse<>("팔로우 등록에 성공하였습니다");
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
