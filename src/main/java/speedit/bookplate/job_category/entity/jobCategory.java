package speedit.bookplate.job_category.entity;

import lombok.*;
import speedit.bookplate.user.entity.CommonDateEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"jobcgId","job","status"})
@Table(name = "jobCategory")
public class jobCategory extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobcgId;    //직업 카테고리 고유번호

    private String job;    //직업

    private Boolean status;    //선택 여부

}

