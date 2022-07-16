package speedit.bookplate.follow.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "follow")
public class Follow extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followerIdx")
    private User follower_user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followedIdx")
    private User followed_user;

    public static Follow createFollow(User follower,User followed){
        Follow follow = new Follow();
        follow.follower_user=follower;
        follow.followed_user=followed;
        return follow;
    }

}
