package speedit.bookplate.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.user.dto.*;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.entity.enumTypes.UserStatus;
import speedit.bookplate.utils.JwtService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Transactional
    public PostUserRes createAccount(PostUserReq postUserReq) throws BaseException {
        try{
            User userReq=postUserConverter(postUserReq);
            User save = userRepository.save(userReq);

            PostUserRes res=new PostUserRes();
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


    public FollowedUserDto followedUserConverter(User user){
        FollowedUserDto followedUserDto = new FollowedUserDto();
        followedUserDto.setNickname(user.getNickname());
        followedUserDto.setCompany(user.getCompany());
        followedUserDto.setJobs(user.getJobs());
        followedUserDto.setProfileImg(user.getProfileImg());
        return followedUserDto;
    }

    public UserDto userConverter(User user){
        UserDto userDto = new UserDto();
        userDto.setProfileImg(user.getProfileImg());
        userDto.setNickname(user.getNickname());
        userDto.setBirth(user.getBirth());
        userDto.setGender(userDto.getGender());
        userDto.setJob(userDto.getJob());
        userDto.setCompany(userDto.getCompany());
        userDto.setCertify(userDto.isCertify());
        userDto.setIntroduction(userDto.getIntroduction());
        return userDto;
    }

    public User postUserConverter(PostUserReq postUserReq){
        User userDto = new User();
        userDto.setBirth(postUserReq.getBirth());
        userDto.setCompany(postUserReq.getCompany());
        userDto.setGender(postUserReq.getGender());
        userDto.setJobs(postUserReq.getJobs());
        userDto.setNickname(postUserReq.getNickname());
        userDto.setNotification(false);
        userDto.setType(postUserReq.getOAuthType());
        return userDto;
    }


}
