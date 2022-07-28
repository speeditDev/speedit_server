package speedit.bookplate.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import speedit.bookplate.booklike.entity.BookLike;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feedlike.entity.FeedLike;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.user.dto.FollowedUserDto;
import speedit.bookplate.user.dto.SignUpReq;
import speedit.bookplate.user.dto.UserDto;
import speedit.bookplate.user.entity.enumTypes.Gender;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import speedit.bookplate.user.entity.enumTypes.UserStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;       //유저 고유번호

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;  //유저 상태

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Feed> feeds = new ArrayList<>(); //회원 등록 피드 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<BookLike> bookLikes = new ArrayList<>(); //회원 책 좋아요 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<FeedLike> feedLikes = new ArrayList<>(); //회원피드 좋아요 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Scrap> scraps = new ArrayList<>(); //회원 피드 스크랩 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "follower")
    private List<Follow> follower_follows = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "followed")
    private List<Follow> followed_follows = new ArrayList<>();

    private String name;        //이름

    private String profileImg;

    @Column(nullable = false)
    private String nickname;    //닉네임

    @Column(nullable = false)
    private int birth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String job;

    private String company;     //소속 회사명

    private String fcmToken; //FCM 토큰 정보

    @Column(nullable = false)
    private Boolean alarmAgree;


    private String companyEmail;  //회사 이메일

    @Column(nullable = false)
    private Boolean isEmailCertified;

    private String introduction; //유저 소개글

    @Column(nullable = false)
    private String oAuthToken;  //소셜 로그인 타입

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OAuthType type;

    public static User SignUpUser(SignUpReq signUpReq){

        return User.builder()
                .birth(signUpReq.getBirth())
                .profileImg(signUpReq.getProfileImg())
                .status(UserStatus.ACTIVE)
                .company(signUpReq.getCompany())
                .gender(signUpReq.getGender())
                .job(signUpReq.getJob())
                .nickname(signUpReq.getNickname())
                .alarmAgree(false)
                .isEmailCertified(false)
                .type(signUpReq.getType())
                .oAuthToken(signUpReq.getO_auth_token())
                .build();
    }

    public static UserDto userConverter(User user){
        return UserDto.builder()
                .profileImg(user.profileImg)
                .nickname(user.nickname)
                .birth(user.birth)
                .gender(String.valueOf(user.gender))
                .job(user.job)
                .company(user.company)
                .isEmailCertified(false)
                .introduction(user.introduction)
                .build();
    }

    public static FollowedUserDto followedUserConverter(User user){
        return FollowedUserDto.builder()
                .nickname(user.nickname)
                .company(user.company)
                .jobs(user.job)
                .profileImg(user.profileImg)
                .build();
    }

    private OAuthType oAuthType; //소셜 로그인 토큰 정보

}
