package speedit.bookplate.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import speedit.bookplate.feed.entity.enumTypes.Status;

import java.time.LocalDateTime;

/**
 * 피드 삭제하기 api response dto
 */
@Data
@AllArgsConstructor
public class DelFeedResDto {
    private Long feedIdx;   //피드 고유번호
    private Status status;  //피드 상태
    private LocalDateTime createdAt; //생성 시간
    private LocalDateTime updatedAt; //업데이트 시간
}
