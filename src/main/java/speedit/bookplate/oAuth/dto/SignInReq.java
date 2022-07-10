package speedit.bookplate.oAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignInReq {
    private String nickname;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
