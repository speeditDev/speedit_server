package speedit.bookplate.scrap.entity;

import lombok.*;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.user.entity.CommonDateEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"status"})
@Table(name = "scrap")
public class Scrap extends CommonDateEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;    //스크랩한 유저 정보

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private Book book;    //스크랩한 책 정보

    @Column(nullable = false)
    private Boolean status;    //선택 여부
}
