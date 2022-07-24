package speedit.bookplate.book.dto;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 알라딘 open api response dto
 */
@Data
public class AladinResDto {
    private String version;   //버전 정보
    private String title;     //title : 알라딘 전체 신간 리스트 - 국내도서
    private List<Item> item = new ArrayList<>();    //도서 정보

}
