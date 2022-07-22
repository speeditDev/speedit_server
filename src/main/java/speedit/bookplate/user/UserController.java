package speedit.bookplate.user;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.user.dto.FollowedUserDto;
import speedit.bookplate.user.dto.PostUserReq;
import speedit.bookplate.user.dto.UserDto;
import speedit.bookplate.utils.JwtService;

import java.util.List;

import static speedit.bookplate.user.entity.enumTypes.UserStatus.INACTIVE;

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

    @PostMapping("/join")
    @ResponseBody
    public BaseResponse<String> join(@RequestBody PostUserReq postUserReq) throws BaseException {
        userService.createAccount(postUserReq);
        return new BaseResponse<>("회원가입에 성공하였습니다");
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

    @GetMapping("/modify/inactive")
    @ResponseBody
    public BaseResponse<String> modifyInactive(){
        try {
            long userIdx = jwtService.getUserIdx();
            userService.inactiveUser(userIdx, INACTIVE);
            return new BaseResponse<>("회원 탈퇴에 성공하였습니다");
        }catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }


    @GetMapping("/getFollowedUser")
    @ResponseBody
    public BaseResponse<List<FollowedUserDto>> getFollowed(){
        /*
        try{
            long userIdx=jwtService.getUserIdx();
            followService.getFollowingUser(userIdx);
            return new BaseResponse<>("팔로잉 목록 조회에 성공했습니다");
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }*/
        List<FollowedUserDto> getFollowedUser = userService.getFollowedUser(1);
        return new BaseResponse<>(getFollowedUser);
    }


}
