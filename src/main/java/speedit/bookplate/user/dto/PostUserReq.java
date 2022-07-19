package speedit.bookplate.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import speedit.bookplate.user.entity.enumTypes.Gender;
import speedit.bookplate.user.entity.enumTypes.OAuthType;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostUserReq {

    private String nickname;

    private int birth;

    private Gender gender;

    private String jobs;

    private String company;

    private String o_auth_token;

    private OAuthType oAuthType;
}
