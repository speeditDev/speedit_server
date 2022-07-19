package speedit.bookplate.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.user.dto.PostUserDto;
import speedit.bookplate.user.dto.PostUserReq;
import speedit.bookplate.user.dto.PostUserRes;
import speedit.bookplate.user.dto.UserDto;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.entity.enumTypes.UserStatus;
import speedit.bookplate.utils.JwtService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;

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

    public void inactiveUser(long userIdx, UserStatus userStatus){
         userRepository.updateInactiveUser(userIdx,userStatus);
    }


    public UserDto getUser(long userIdx){
        return userConverter(userRepository.findByUserIdx(userIdx));
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
