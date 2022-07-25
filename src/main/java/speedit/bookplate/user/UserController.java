package speedit.bookplate.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.follow.FollowService;
import speedit.bookplate.user.dto.*;
import speedit.bookplate.utils.JwtService;
import speedit.bookplate.utils.ValidationExceptionProvider;

import javax.validation.Valid;
import java.util.List;

import static speedit.bookplate.user.entity.enumTypes.UserStatus.INACTIVE;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private FollowService followService;
    private JwtService jwtService;

    @PostMapping("/sign-up")
    @ResponseBody
    public BaseResponse<SignUpRes> SingUp(@RequestBody @Valid SignUpReq signUpReq, Errors errors){
        if(errors.hasErrors()) {
            BaseException exception = ValidationExceptionProvider.throwValidError(errors);
            return new BaseResponse<>(exception.getStatus());
        }else{
            SignUpRes signUpRes = userService.SignUp(signUpReq);
            return new BaseResponse<>(signUpRes);
        }
    }

    @PostMapping("/nickname")
    @ResponseBody
    public BaseResponse<String> checkNickname(@RequestBody @Valid PostNickname postNickname,Errors errors){
        if(errors.hasErrors()){
            BaseException exception=ValidationExceptionProvider.throwValidError(errors);
            return new BaseResponse<>(exception.getStatus());
        }else if(userService.checkNickname(postNickname.getNickname())){
            return new BaseResponse<>(BaseResponseStatus.DUPLICATE_NICKNAME);
        }else{
            return new BaseResponse<>("사용 가능한 닉네임입니다.");
        }
    }

    @GetMapping("/profiles")
    @ResponseBody
    public BaseResponse<UserDto> getUserProfile(){
        try {
            long userIdx = jwtService.getUserIdx();
            UserDto getUserProfile = userService.getUserProfile(userIdx);
            return new BaseResponse<>(getUserProfile);
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public BaseResponse<String> deleteUser(){
        try {
            long userIdx = jwtService.getUserIdx();
            userService.deleteUser(userIdx, INACTIVE);
            return new BaseResponse<>("회원 탈퇴에 성공하였습니다");
        }catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }



    @GetMapping("/getFollowedUser")
    @ResponseBody
    public BaseResponse<String> getFollowed(){

        try{
            long userIdx=jwtService.getUserIdx();
            //followService.getFollowingUser(userIdx);
            return new BaseResponse<>("팔로잉 목록 조회에 성공했습니다");
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }

    }


}
