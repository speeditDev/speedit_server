package speedit.bookplate.feedlike.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "feedLike")
public class FeedLike extends BaseTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;  //피드 좋아요한 유저 정보

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedIdx")
    private Feed feed; //유저가 좋아요 클릭한 피드 정보

}
