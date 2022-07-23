package speedit.bookplate.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import speedit.bookplate.user.entity.enumTypes.Gender;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpReq {

    @NotEmpty(message = "닉네임을 입력해주세요")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{1,10}$",message = "닉네임은 특수 문자를 제외한 10자리 이내로 입력해주세요")
    private String nickname;

    private String profileImg;

    @NotEmpty(message = "태어난 연도 4자리를 입력해주세요")
    private int birth;

    @NotEmpty(message = "성별을 입력해주세요")
    private Gender gender;

    @NotEmpty(message = "직업을 입력해주세요")
    private String jobs;

    private String company;

    @NotEmpty(message = "OAuth 토큰값을 입력해주세요")
    private String o_auth_token;

    @NotEmpty(message = "소셜 로그인 타입을 입력해주세요")
    private OAuthType oAuthType;

}
