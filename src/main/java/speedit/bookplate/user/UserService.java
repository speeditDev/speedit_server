package speedit.bookplate.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.user.dto.*;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.entity.enumTypes.UserStatus;
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
    public SignUpRes SignUp(SignUpReq signUpReq) throws BaseException {
        try{
            User userReq=postUserConverter(signUpReq);
            User save = userRepository.save(userReq);

            SignUpRes res=new SignUpRes();
            res.setUserIdx(save.getUserIdx());
            res.setJwt(jwtService.createJwt(save.getUserIdx()));
            return res;
        }catch (Exception exception){
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

    public boolean checkNicknameDuplicate(String nickname){
        return userRepository.existsByNickname(nickname);
    }

    @Transactional
    public void inactiveUser(long userIdx, UserStatus userStatus){
         userRepository.updateInactiveUser(userIdx,userStatus);
    }

    public List<FollowedUserDto> getFollowedUser(long userIdx){
        List<User> follwedUser = userRepository.findFollowedByFollowIdx(userIdx);
        List<FollowedUserDto> followedUserList=new ArrayList<>();
        for(User user:follwedUser){
            followedUserList.add(followedUserConverter(user));
        }
        return followedUserList;
    }


    public UserDto getUser(long userIdx){
        return userConverter(userRepository.findByUserIdx(userIdx));
    }




}
