package speedit.bookplate.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import speedit.bookplate.booklike.entity.BookLike;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feedlike.entity.FeedLike;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.user.entity.enumTypes.Gender;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import speedit.bookplate.user.entity.enumTypes.UserStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor()
@ToString(of = {"userId","status","userType","profileImg","nickname", "birth","gender","job","company","token","notification", "companyEmail", "isCertify",
        "introduction", "oAuthType" })
@Table(name = "user")
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Feed> feeds = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<BookLike> bookLikes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<FeedLike> feedLikes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Scrap> scraps = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "follower_user")
    private List<Follow> follower_follows = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "followed_user")
    private List<Follow> followed_follows = new ArrayList<>();

    private String profileImg;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private int birth;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String jobs;

    private String company;

    private String token; //FCM 토큰 정보

    @Column(nullable = false)
    private Boolean notification;

    private String companyEmail;

    @Column(nullable = false)
    private boolean isCertify;

    private String introduction;

    @Column(nullable = false)
    private String oAuthToken;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OAuthType type;

}
