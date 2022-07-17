package speedit.bookplate.oAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.oAuth.dto.PostOauthReq;
import speedit.bookplate.oAuth.dto.PostOauthRes;

@Controller
@RequestMapping("")
public class oAuthController {

    @Autowired
    private final oAuthService oAuthService;

    public oAuthController(oAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @ResponseBody
    @PostMapping("/oAuth/kakao")
    public BaseResponse<PostOauthRes> kakaoLogin(@RequestBody PostOauthReq postOauthReq){
        try {
            PostOauthRes postOauthRes = oAuthService.kakaoLogin(postOauthReq.getAccessToken(),postOauthReq.getType());
            return new BaseResponse<>(postOauthRes);
        } catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }



}
