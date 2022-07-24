package speedit.bookplate.feed.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 피드 등록하기 api request dto
 */
@Data
public class RegFeedReqDto {

//    @NotBlank(message = "게시물 고유번호를 입력해주세요")
//    @ApiModelProperty(value = "게시물 고유번호", required = true)
//    private String aToken;
    @NotNull(message = "유저 고유번호를 입력해주세요")
    @ApiModelProperty(value = "유저 고유번호", required = true)
    private Long id;
    @NotBlank(message = "문장정보를 입력해주세요")
    @ApiModelProperty(value = "문장정보", required = true)
    private String contents;
    @NotNull(message = "선택한 책 고유번호를 입력해주세요")
    @ApiModelProperty(value = "선택한 책 고유번호", required = true)
    private Long bookIdx;
    @NotNull(message = "피드에 대한 의견을 입력해주세요")
    @ApiModelProperty(value = "피드에 대한 의견", required = true)
    private String opinion;
    @NotBlank(message = "피드 배경색을 입력해주세요")
    @ApiModelProperty(value = "피드 배경색", required = true)
    private String color;
    @NotNull(message = "나만 보기 여부")
    @ApiModelProperty(value = "나만 보기 여부", required = true)
    private Boolean isPrivate;

}
