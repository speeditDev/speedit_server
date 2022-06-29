package speedit.bookplate.book.entity;

import lombok.Getter;
import speedit.bookplate.feed.entity.Feed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Book {

    @Id
    @GeneratedValue
    private Long bookIdx;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "book")
    private List<Feed> feeds= new ArrayList<>();

    private String bookName;

    private String author;

    private String category;

    private String thumbnail;

    private String buyingUrl;

    private String introduction;

    private String publisher;

    private String releaseDate;

}
