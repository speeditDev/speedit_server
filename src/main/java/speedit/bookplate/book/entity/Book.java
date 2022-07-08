package speedit.bookplate.book.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.ToString;
import speedit.bookplate.booklike.entity.BookLike;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.user.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"bookIdx", "bookName", "author", "category", "thumbnail", "buyingUrl", "introduction", "publisher", "releaseDate"})
@Table(name = "book")
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long bookIdx;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Feed> feeds= new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<BookLike> bookLikes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Scrap> scraps = new ArrayList<>();

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String category;

    private String thumbnail;

    @Column(nullable = false)
    private String buyingUrl;

    private String introduction;

    private String publisher;

    private String releaseDate;

}
