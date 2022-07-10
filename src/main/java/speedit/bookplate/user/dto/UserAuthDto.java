package speedit.bookplate.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAuthDto {

    private String nickname;

    private String password;

    private boolean notification;

    private boolean isCertify;

    private String jwt;

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
