package speedit.bookplate.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRes {
    private long userIdx;
    private String jwt;
}
