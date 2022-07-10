package speedit.bookplate.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.oAuth.dto.PostOauthRes;
import speedit.bookplate.oAuth.dto.SignInReq;
import speedit.bookplate.user.dto.UserAuthDto;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.utils.JwtService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public UserAuthDto createAccount(UserAuthDto dto) throws BaseException {
        String pwd;
        try{
            pwd=passwordEncoder.encode(dto.getPassword());
            dto.setPassword(pwd);
        }catch(Exception ignored){
            throw new BaseException(BaseResponseStatus.PASSWORD_ENCRYPTION_ERROR);
        }
        try{
            User user = User.createUser(dto);
            User save=userRepository.save(user);

            dto.setJwt(jwtService.createJwt(save.getUserIdx()));
            return dto;
        }catch (Exception exception){
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

    public boolean checkNicknameDuplicate(String nickname){
        return userRepository.existsByNickname(nickname);
    }




}
