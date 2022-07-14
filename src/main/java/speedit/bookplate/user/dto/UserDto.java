package speedit.bookplate.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String name;

    private String profileImg;

    private String nickname;

    private LocalDateTime birth;

    private String gender;

    private String job;

    private String company;

    private boolean isCertify;

    private String introduction;


}
