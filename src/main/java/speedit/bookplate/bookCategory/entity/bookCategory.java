package speedit.bookplate.bookCategory.entity;

import lombok.*;
import speedit.bookplate.user.entity.CommonDateEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"bookcgId","category","status"})
@Table(name = "bookCategory")
public class bookCategory extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookcgId;    //책 카테고리 고유번호

    private String category;    //책 카테고리

    private Boolean status;    //선택 여부

}
