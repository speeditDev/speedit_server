package speedit.bookplate.scrap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ScrapResDto {
    private Long feedIdx;  //피드 고유번호
    private Boolean status; //스크랩 상태
    private LocalDateTime createdAt; //생성 시간
}
