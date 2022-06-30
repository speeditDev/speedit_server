package speedit.bookplate.feedlike.entity;

import lombok.Getter;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
public class FeedLike implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedIdx")
    private Feed feed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
