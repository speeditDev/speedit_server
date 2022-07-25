package speedit.bookplate.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import speedit.bookplate.feed.entity.enumTypes.Status;

import java.time.LocalDateTime;

/**
 * 피드 수정하기 api response dto
 */
@Data
@AllArgsConstructor
public class AmdFeedResDto {
    private Long feedIdx;       //피드 고유번호
    private Status status;      //피드 상태 N: 삭제된 피드, Y: 삭제되지 않은 피드
    private String contents;    //문장 정보
    private String bookName;    //책 이름
    private String opinion;     //피드에 대한 의견
    private String color;       //피드 배경색
    private Boolean isPrivate;  //나만 보기 여부
    private LocalDateTime createdAt;    //생성 시간
    private LocalDateTime updatedAt;    //업데이트 시간
}
