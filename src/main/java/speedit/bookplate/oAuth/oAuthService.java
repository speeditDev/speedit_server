package speedit.bookplate.oAuth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.oAuth.dto.KakaoUserInfo;
import speedit.bookplate.oAuth.dto.PostOauthRes;
import speedit.bookplate.oAuth.dto.SignInReq;
import speedit.bookplate.user.UserRepository;
import speedit.bookplate.user.UserService;
import speedit.bookplate.user.dto.UserAuthDto;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import speedit.bookplate.utils.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class oAuthService {

    private final KakaoOAuth2 kakaoOAuth2;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /*
    @Value("${OAuth.KAKAO_TOKEN}")
    private String KAKAO_TOKEN;*/

    public PostOauthRes kakaoLogin(String accessToken, OAuthType oAuthType) throws BaseException {
        KakaoUserInfo kakaoUserInfo=kakaoOAuth2.getUserInfo(accessToken);
        String nickname = kakaoUserInfo.getNickname();
        String profileImg =kakaoUserInfo.getProfileImg();

        Optional<User> nicknameUser = userRepository.findByNicknameAndType(nickname,oAuthType);
        try{
            long userIdx = nicknameUser.get().getUserIdx();
            return new PostOauthRes(userIdx, jwtService.createJwt(userIdx));
        }catch(Exception exception){
            throw new BaseException(BaseResponseStatus.JOIN_USER);
        }
        /*
        User user = null;

        Optional<User> nicknameUser = userRepository.findByNickname(nickname);
        if(nicknameUser.isPresent()) {
            user = nicknameUser.get();
        } else{
            UserAuthDto userReq = UserAuthDto.builder()
                    .nickname(nickname)
                    .password(passwordEncoder.encode(kakaoId+KAKAO_TOKEN))
                    .isCertify(false)
                    .notification(false)
                    .build();

            User newUser = User.createUser(userReq);
            User save = userRepository.save(newUser);
            user=save;
        }

        SignInReq signInReq = SignInReq.builder()
                .nickname(user.getNickname())
                .password(kakaoId+KAKAO_TOKEN)
                .build();

         */

        //return userService.createAccount(signInReq);
    }



}
