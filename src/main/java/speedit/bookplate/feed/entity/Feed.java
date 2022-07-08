package speedit.bookplate.feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.feed.entity.enumTypes.Status;
import speedit.bookplate.feedlike.entity.FeedLike;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"feedId","status","contests","likeCnt","isLiked","isScraped","isPrivate","color","opinion"})
@Table(name = "feed")
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedIdx;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookIdx")
    private Book book;

    @JsonManagedReference
    @OneToMany(mappedBy = "feed")
    private List<FeedLike> feedLikes = new ArrayList<>();

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Integer likeCnt;

    @Column(nullable = false)
    private Boolean isLiked;

    @Column(nullable = false)
    private Boolean isScraped;

    @Column(nullable = false)
    private Boolean isPrivate;

    @Column(nullable = false)
    private String color;

    private String opinion;

}
