package speedit.bookplate.bookcategory.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import speedit.bookplate.user.entity.BaseTimeEntity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"bookCategoryId", "bookCategory", "status"})
@Table(name = "bookCategory")
public class BookCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookCategoryId;    //책 카테고리 고유번호

    @ElementCollection()
    private Map<String,Boolean> bookCategory;   //책 카테고리, 선택 유무(ture : 선택, false : 미선택)

//    private Boolean status;

    public static BookCategory createBookCategory(Map<String,Boolean> bookCategory) {
        BookCategory bookCategory1 = new BookCategory();
        bookCategory1.setBookCategory(bookCategory);
        return bookCategory1;
    }
}
