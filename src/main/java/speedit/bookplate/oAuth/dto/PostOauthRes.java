package speedit.bookplate.oAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostOauthRes {
    private int userIdx;
    private String jwt;
}
