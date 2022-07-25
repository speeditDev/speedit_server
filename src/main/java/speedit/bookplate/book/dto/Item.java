package speedit.bookplate.book.dto;

import lombok.Data;


@Data
public class Item {
    private String title;       //책 제목
    private String author;      //작가명
    private String publisher;   //출판사
    private String categoryName; //알라딘 카테고리 이름
    private Long categoryId;    //알라딘 카테고리 Id
    private String cover;       //책 이미지
    private String pubDate;     //출간일
}
