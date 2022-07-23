package speedit.bookplate.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FollowedUserDto {

    private String profileImg;

    private String nickname;

    private String jobs;

    private String company;

}
