package speedit.bookplate.oAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostOauthRes {
    private long userIdx;
    private String jwt;
}
