package speedit.bookplate.scrap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CancelScrapResDto {
    private Long scrapId;  //스크렙 고유번호
    private Long feedIdx;  //피드 고유번호
    private Boolean status; //스크랩 상태
    private LocalDateTime createdAt; //생성 시간
    private LocalDateTime updatedAt; //업데이트 시간
}
