package speedit.bookplate.follow.dto;

import lombok.Getter;

@Getter
public class FollowedDto {

    private String profileImg;

    private String nickname;

    private String job;

    private String company;

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
