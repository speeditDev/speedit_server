package speedit.bookplate.oAuth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponseStatus;
import speedit.bookplate.oAuth.dto.KakaoUserInfo;
import speedit.bookplate.oAuth.dto.PostOauthRes;
import speedit.bookplate.utils.JwtService;

@Transactional
@RequiredArgsConstructor
@Service
public class oAuthService {

    private final KakaoOAuth2 kakaoOAuth2;
    private final JwtService jwtService;

    /*
    public PostOauthRes kakaoLogin(String accessToken) throws BaseException{
        KakaoUserInfo kakaoUserInfo=kakaoOAuth2.getUserInfo(accessToken);
        String nickanme=kakaoUserInfo.getNickname();
        String email=kakaoUserInfo.getEmail();

        try{

        }catch(Exception exception){
            throw new BaseException(BaseResponseStatus.INVALID_JWT);
        }
    }*/



}
