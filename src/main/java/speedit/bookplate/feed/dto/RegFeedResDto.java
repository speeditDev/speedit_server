package speedit.bookplate.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import speedit.bookplate.feed.entity.enumTypes.Status;

import java.time.LocalDateTime;

/**
 * 피드 등록하기 api response dto
 */
@Data
@AllArgsConstructor
public class RegFeedResDto {
    private Long feedIdx;     //피드 고유번호
    private Status status;    //피드 상태 N: 삭제된 피드, Y: 삭제되지 않은 피드
    private String bookName;  //책 이름
    private String contents;  //피드 내용
    private String opinion;   //피드 의견
    private String color;     //피드 백그라운드 컬러
    private Boolean isPrivate; //나만보기 여부
    private LocalDateTime createdAt; //생성 시간
}
