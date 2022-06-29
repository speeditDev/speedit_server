package speedit.bookplate.feed.entity;

import lombok.Getter;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Feed {

    @Id
    @GeneratedValue
    private Long feedIdx;

    private boolean status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookIdx")
    private Book book;

    private String contents;

    private int likeCnt;

    private boolean isLiked;

    private boolean isScraped;

    private boolean isPrivate;

    private String color;

    private String opinion;

}
