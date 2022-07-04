package speedit.bookplate.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import speedit.bookplate.bookLike.entity.BookLike;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feedLike.entity.FeedLike;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.user.entity.enumTypes.Gender;
import speedit.bookplate.user.entity.enumTypes.Status;
import speedit.bookplate.user.entity.enumTypes.UserType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"userId","status","userType","profileImg","nickname", "birth","gender","job","company","token","notification", "companyEmail", "isCertify",
"introduction", "oAuthType" })
@Table(name = "user")
public class User extends CommonDateEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;    //유저 고유번호

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;  //유저 상태

    @Column(nullable = false)
    private UserType userType;  //회원 유형

    private String profileImg;  //프로필 이미지

    @Column(nullable = false)
    private String nickname;    //닉네임

    @Column(nullable = false)
    private LocalDateTime birth;    //유저 태어난 년도

    @Column(nullable = false)
    private Gender gender;  //유저 성별

    @Column(nullable = false)
    private String job;    //유저 직업

    private String company;    //소속 회사명

    private String token;   //FCM 토큰 정보

    @Column(nullable = false)
    private Boolean notification;   //알림 설정 여부

    private String companyEmail;    //회사 이메일

    @Column(nullable = false)
    private Boolean isCertify;   //유저 소속 회사 인증 여부

    private String introduction;    //유저 소개글

    @Column(nullable = false)
    private String oAuthType;   //소셜 로그인 타입

    @Column(nullable = false)
    private String oAuthToken;   //소셜 로그인 토큰 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Follow> follows = new ArrayList<>();   //팔로우 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Feed> feeds = new ArrayList<>();   //회원 등록 피드 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<BookLike> bookLikes = new ArrayList<>();   //좋아요 한 책 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<FeedLike> feedLikes = new ArrayList<>();   //좋아요 한 피드 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Scrap> scraps = new ArrayList<>();   //스크랩한 책 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "follower")
    private List<Follow> follower_follows = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "followed")
    private List<Follow> followed_follows = new ArrayList<>();

}