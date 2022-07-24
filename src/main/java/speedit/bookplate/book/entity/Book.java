package speedit.bookplate.book.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import speedit.bookplate.booklike.entity.BookLike;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feed.entity.enumTypes.Status;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.user.entity.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(of = {"bookIdx", "bookName", "author", "category", "thumbnail", "buyingUrl", "introduction", "publisher", "releaseDate"})
@Table(name = "book")
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookIdx;   //책 고유번호

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Feed> feeds = new ArrayList<>();   //피드 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<BookLike> bookLikes = new ArrayList<>();   //책 좋아요 정보

    @Column(nullable = false)
    private String bookName;   //책 이름

    @Column(nullable = false)
    private String author;     //작가명

    private String category;   //책그릇 카테고리명

    @Column(nullable = false)
    private String aladinCategory;  //알라딘 카테고리명

    @Column(nullable = false)
    private Long categoryId;   //알라딘 카테고리 cid 번호

    private String thumbnail;  //책 이미지

    @Column(nullable = false)
    private String buyingUrl;  //책 구매 Url

    private String introduction;   //책 설명

    private String publisher;   //출판사

    private String releaseDate; //출간일

    public static Book createBook(String bookName, String author, String publisher, String aladinCategory, Long categoryId, String thumbnail, String releaseDate) {
        Book book = new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setAladinCategory(aladinCategory);
        book.setCategoryId(categoryId);
        book.setThumbnail(thumbnail);
        book.setBuyingUrl("https://link.coupang.com/a/oerSQ");
        book.setReleaseDate(releaseDate);
        return book;
    }

//    public static Book settingCategory(Set<String> category){
//        Book book = new Book();
//        book.setCategory(category.toString());
//        return book;
//    }
}
