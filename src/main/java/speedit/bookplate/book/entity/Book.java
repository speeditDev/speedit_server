package speedit.bookplate.book.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import speedit.bookplate.bookLike.entity.BookLike;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feed.entity.enumTypes.Status;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.user.entity.CommonDateEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"bookId", "bookName", "author", "category", "thumbnail", "buyingUrl", "introduction", "publisher", "releaseDate"})
@Table(name = "book")
public class Book extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;    //책 고유번호

    @Column(nullable = false)
    private String bookName;    //피드 상태

    @Column(nullable = false)
    private String author;    //작가명

    @Column(nullable = false)
    private String category;    //책 카테고리

    private String thumbnail;   //책 이미지

    @Column(nullable = false)
    private String buyingUrl;   //책 구매 URL

    private String introduction;    //책 설명

    private String publisher;   //출판사

    private String releaseDate;    //출간일

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Feed> feeds = new ArrayList<>();   //팔로우 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<BookLike> bookLikes = new ArrayList<>();




}
