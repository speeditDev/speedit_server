package speedit.bookplate.scrap.entity;

import lombok.*;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feed.entity.enumTypes.Status;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"scrapId","status"})
@Table(name = "scrap")
public class Scrap extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrapId;   //스크랩 고유번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;  //스크랩한 유저 정보

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedIdx")
    private Feed feed;  //스크랩한 피드 정보

    @Column(nullable = false)
    private Boolean status; //스크랩 상태

    public static Scrap createScrap(Feed feed){
        Scrap scrap = new Scrap();
        scrap.setFeed(feed);
        scrap.setStatus(true);
        return scrap;
    }
}