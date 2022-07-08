package speedit.bookplate.oAuth;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import speedit.bookplate.oAuth.dto.KakaoUserInfo;

@Component
public class KakaoOAuth2 {

    public KakaoUserInfo getUserInfo(String accessToken){
        KakaoUserInfo userInfo = getUserInfoByToken(accessToken);

        return userInfo;
    }

    public KakaoUserInfo getUserInfoByToken(String accessToken){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+accessToken);
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        RestTemplate rs=new RestTemplate();
        HttpEntity<MultiValueMap<String,String>> KakaoProfileRequest = new HttpEntity<>(headers);

        ResponseEntity<String> response = rs.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                KakaoProfileRequest,
                String.class
        );

        JSONObject body = new JSONObject(response.getBody());
        String email = body.getJSONObject("kakao_account").getString("email");
        String nickname = body.getJSONObject("properties").getString("nickname");

        return new KakaoUserInfo(nickname,email);
    }

}
