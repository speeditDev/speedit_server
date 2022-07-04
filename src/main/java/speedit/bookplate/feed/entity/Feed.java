package speedit.bookplate.feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.feed.entity.enumTypes.Status;
import speedit.bookplate.feedLike.entity.FeedLike;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"feedId","status","contests","likeCnt","isLiked","isScraped","isPrivate","color","opinion"})
@Table(name = "feed")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;    //피드 고유번호

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;    //피드 상태

    @Column(nullable = false)
    private String contests;    //피드 내용

    @Column(nullable = false)
    private Integer likeCnt;    //피드 등록 문장 좋아요 개수

    @Column(nullable = false)
    private Boolean isLiked;    //좋아요 클릭 여부

    @Column(nullable = false)
    private Boolean isScraped;  //스크랩 클릭 여부

    @Column(nullable = false)
    private Boolean isPrivate;  //나만 보기 피드 여부

    @Column(nullable = false)
    private String color;   //피드 백그라운드 컬러

    private String opinion;    //피드 작성자 의견

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;  //작성자 정보

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;  //책 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "feed")
    private List<FeedLike> feedLikes = new ArrayList<>();   //피드 좋아요 정보


}
