package speedit.bookplate.feedLike.entity;

import lombok.*;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.user.entity.CommonDateEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "feedLike")
public class FeedLike extends CommonDateEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;  //좋아요 클릭한 유저 정보

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedId")
    private Feed feed;   //유저가 좋아요 클릭한 피드 정보


}
