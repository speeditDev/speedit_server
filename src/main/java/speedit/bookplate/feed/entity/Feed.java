package speedit.bookplate.feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
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
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"feedIdx", "status", "contents", "likeCnt", "isLiked", "isScraped", "isPrivate", "color", "opinion"})
@Table(name = "feed")
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedIdx;   //피드 고유번호

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;  //피드 상태

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;      //작성한 유저 정보

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookIdx")
    private Book book;      //도서 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "feed")
    private List<FeedLike> feedLikes = new ArrayList<>();   //피드 좋아요 정보

    @Column(nullable = false)
    private String contents;    //피드 내용

//    @Column(nullable = false)
    private Integer likeCnt;    //피드 등록 문장 좋아요 개수

//    @Column(nullable = false)
    private Boolean isLiked;    //좋아요 클릭 여부

//    @Column(nullable = false)
    private Boolean isScraped;  //스크랩 클릭 여부

    @Column(nullable = false)
    private Boolean isPrivate;  //나만 보기 여부

    @Column(nullable = false)
    private String color;       //피드 백그라운드 컬러

    private String opinion;     //피드 작성자 의견

    @JsonManagedReference
    @OneToMany(mappedBy = "feed")
    private List<Scrap> scraps = new ArrayList<>();   //피드 스크랩 정보

    public static Feed createFeed(String contents, speedit.bookplate.book.entity.Book book, String opinion, String color, Boolean isPrivate){
        Feed feed = new Feed();
        feed.setContents(contents);
        feed.setBook(book);
        feed.setStatus(Status.Y);
        feed.setOpinion(opinion);
        feed.setColor(color);
        feed.setIsPrivate(isPrivate);
        return feed;
    }
}
