package speedit.bookplate.user.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String name;

    private String profileImg;

    private String nickname;

    private int birth;

    private String gender;

    private String job;

    private String company;

    private boolean isCertify;

    private String introduction;

    private boolean notification;

    private String o_auth_token;


}
