package speedit.bookplate.bookLike.entity;

import lombok.*;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.user.entity.CommonDateEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@ToString(of = {""})
@Table(name = "bookLike")
public class BookLike extends CommonDateEntity {


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private Book book;

}
