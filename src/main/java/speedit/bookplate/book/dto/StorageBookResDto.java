package speedit.bookplate.book.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 알라딘 도서 정보 -> 책그릇 도서 정보 저장 api response dto
 */
@Data
@NoArgsConstructor
public class StorageBookResDto  {
    private Long bookIdx;     //책 고유번호
    private String bookName;  //책 이름
    private String author;    //작가명
    private String thumbnail; //책 이미지
    private String publisher; //출판사
    private Long categoryId;  //알라딘 카테고리 Id
    private String releaseDate; //출간일
    private String buyingUrl; //구매 Url

}
