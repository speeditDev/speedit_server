package speedit.bookplate.scrap.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ScarpReqDto {
    @NotNull(message = "선택한 피드 고유번호를 입력해주세요")
    @ApiModelProperty(value = "선택한 피드 고유번호", required = true)
    private Long feedIdx;
}
