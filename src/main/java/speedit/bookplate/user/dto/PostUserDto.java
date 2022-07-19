package speedit.bookplate.user.dto;

import lombok.*;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.enumTypes.Gender;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import speedit.bookplate.user.entity.enumTypes.UserStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostUserDto extends BaseTimeEntity {

    private int birth;

    private String company;

    private String company_email;

    private Gender gender;

    private String introduction;

    private boolean is_certify;

    private String jobs;

    private String nickname;

    private boolean notification;

    private String o_Auth_Token;

    private OAuthType type;

}
