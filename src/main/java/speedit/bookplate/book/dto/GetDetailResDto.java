package speedit.bookplate.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 도서 상세정보 조회 api response dto
 */
@Data
@AllArgsConstructor
public class GetDetailResDto {
    private Long bookIdx;
    private String bookName;
    private String author;
    private String thumbnail;
    private String category;
    private String releaseDate;
    private String publisher;
    private String introduction;
    //private Boolean bookLike;
}
