package speedit.bookplate.user.dto;

import lombok.Getter;

@Getter
public class UpdateProfileDto {

    private String profileImg;

    private String nickname;

    private String job;

    private String company;

    private boolean isEmailCertified;

    private String introduction;

}
