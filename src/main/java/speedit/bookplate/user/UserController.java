package speedit.bookplate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.user.dto.UserDto;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.utils.JwtService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
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

    @GetMapping("/profile")
    @ResponseBody
    public BaseResponse<UserDto> getUser(){
        try {
            long userIdx = jwtService.getUserIdx();
            UserDto getUserProfile = userService.getUser(userIdx);
            return new BaseResponse<>(getUserProfile);
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }


}
