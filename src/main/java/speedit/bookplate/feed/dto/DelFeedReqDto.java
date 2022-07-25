package speedit.bookplate.feed.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 피드 삭제하기 api request dto
 */
@Data
public class DelFeedReqDto {

//    @NotBlank(message = "엑세스 토큰을 입력해주세요")
//    @ApiModelProperty(value = "엑세스 토큰", required = true)
//    private String aToken;

//    @NotNull(message = "회원 고유번호를 입력해주세요")
//    @ApiModelProperty(value = "회원 고유번호", required = true)
//    private Long id;

    @NotNull(message = "특정 피드 고유번호를 입력해주세요")
    @ApiModelProperty(value = "특정 피드 고유번호", required = true)
    private Long feedIdx;
}
