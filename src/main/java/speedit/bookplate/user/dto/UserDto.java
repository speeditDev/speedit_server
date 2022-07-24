package speedit.bookplate.user.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String nickname;

    private String profileImg;

    private int birth;

    private String gender;

    private String job;

    private String company;

    private boolean isEmailCertified;

    private String introduction;

    private boolean alarmAgree;

    private String o_auth_token;

}
