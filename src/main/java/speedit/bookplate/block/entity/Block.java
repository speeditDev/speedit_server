package speedit.bookplate.block.entity;

import lombok.Getter;
import speedit.bookplate.user.entity.BaseTimeEntity;
import speedit.bookplate.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "block")
@Getter
public class Block extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long blockIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberIdx")
    private User memberUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "targetIdx")
    private User targetUser;
    
}
