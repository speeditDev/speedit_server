package speedit.bookplate.oAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostOauthReq {
    private String accessToken;
    private String type;
}
