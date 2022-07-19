package speedit.bookplate.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostUserRes {
    private long userIdx;
    private String jwt;
}
