package speedit.bookplate.report.entity;

import lombok.Getter;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Table(name="report")
public class Report extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberIdx")
    private User memberUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "targetIdx")
    private User targetUser;
    
}
