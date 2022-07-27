package speedit.bookplate.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.user.dto.*;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.entity.enumTypes.UserStatus;
import speedit.bookplate.user.repositroy.UserRepository;
import speedit.bookplate.utils.JwtService;
import java.util.ArrayList;
import java.util.List;

import static speedit.bookplate.user.entity.User.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Transactional
    public SignUpRes SignUp(SignUpReq signUpReq){
        User userReq=SignUpUser(signUpReq);
        User save = userRepository.save(userReq);

        SignUpRes res=new SignUpRes();
        res.setUserIdx(save.getUserIdx());
        res.setJwt(jwtService.createJwt(save.getUserIdx()));
        return res;
    }

    public boolean checkNickname(String nickname){
        return userRepository.existsByNickname(nickname);
    }

    @Transactional
    public void deleteUser(long userIdx, UserStatus userStatus){
         userRepository.deleteUser(userIdx,userStatus);
    }

    @Transactional
    public void modifyProfile(long userIdx,String nickname,String profileImg,String job,String company,boolean isEmailCertified,String intro){
        userRepository.modifyProfile(userIdx,nickname,profileImg,job,company,isEmailCertified,intro);
    }

    public List<FollowedUserDto> getFollowedUser(long userIdx){
        List<User> follwedUser = userRepository.findFollowedByFollowIdx(userIdx);
        List<FollowedUserDto> followedUserList=new ArrayList<>();
        for(User user:follwedUser){
            followedUserList.add(followedUserConverter(user));
        }
        return followedUserList;
    }

    public UserDto getUserProfile(long userIdx){
        return userConverter(userRepository.findByUserIdx(userIdx));
    }

}
