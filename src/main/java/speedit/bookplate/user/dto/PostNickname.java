package speedit.bookplate.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
public class PostNickname {

    @NotEmpty(message = "닉네임을 입력해주세요")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{1,10}$",message = "닉네임은 특수 문자를 제외한 10자리 이내로 입력해주세요")
    private String nickname;

}
