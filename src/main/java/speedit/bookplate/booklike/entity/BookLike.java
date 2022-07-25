package speedit.bookplate.booklike.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "book_like")
public class BookLike extends BaseTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;  //좋아요한 유저 정보

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookIdx")
    private Book book;  //유저가 좋아요 클릭한 책 정보

}
