package speedit.bookplate.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 도서 검색하기 api response dto
 */
@AllArgsConstructor
@Data
public class SearchBookResDto {
    private Long bookIdx;    //책 고유번호
    private String bookName; //책 이름
    private String thumbnail; //책 이미지
    private String author;   //작가명
}
