package speedit.bookplate.oAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import speedit.bookplate.user.entity.enumTypes.OAuthType;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PostOauthReq {
    private String accessToken;
    private OAuthType type;
}
