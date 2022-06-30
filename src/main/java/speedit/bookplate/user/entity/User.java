package speedit.bookplate.user.entity;

import lombok.Getter;
import speedit.bookplate.booklike.entity.BookLike;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feedlike.entity.FeedLike;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.user.entity.enumTypes.OAuthType;
import speedit.bookplate.user.entity.enumTypes.UserType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long userIdx;

    @Enumerated(EnumType.STRING)
    private UserType status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user")
    private List<Feed> feeds = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<BookLike> bookLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<FeedLike> feedLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Scrap> scraps = new ArrayList<>();

    private String name;

    private String profileImg;

    private String nickname;

    private String birth;

    private String gender;

    private String jobs;

    private String company;

    private boolean isCertify;

    private String introduction;

    private String oAuthToken;

    @Enumerated(EnumType.STRING)
    private OAuthType oAuthType;


}
