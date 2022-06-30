package speedit.bookplate.booklike.entity;

import lombok.Getter;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
public class BookLike implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookIdx")
    private Book book;

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
