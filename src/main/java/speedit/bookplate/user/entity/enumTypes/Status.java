package speedit.bookplate.user.entity.enumTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    //N: 탈퇴한 유저, Y: 활성화된 유저
    N , Y
}
