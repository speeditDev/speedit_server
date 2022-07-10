package speedit.bookplate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.config.BaseResponseStatus;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/checkNickname")
    @ResponseBody
    public BaseResponse<String> checkNickname(@RequestBody String nickname){
        if(nickname.isEmpty()){
            return new BaseResponse<>(BaseResponseStatus.EMPTY_NICKNAME);
        } else if(userService.checkNicknameDuplicate(nickname)==true){
            return new BaseResponse<>(BaseResponseStatus.DUPLICATE_NICKNAME);
        }else{
            return new BaseResponse<>("사용 가능한 닉네임입니다.");
        }
    }
}
