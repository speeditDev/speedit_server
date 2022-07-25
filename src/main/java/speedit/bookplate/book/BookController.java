package speedit.bookplate.book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.book.dto.SearchBookResDto;
import speedit.bookplate.book.dto.StorageBookResDto;
import speedit.bookplate.book.dto.GetDetailResDto;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.book.repository.BookRepository;
import speedit.bookplate.bookcategory.BookCategoryService;
import speedit.bookplate.config.BaseResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(tags = {"Book"})
@RequiredArgsConstructor
@RestController
@RequestMapping
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    private final ModelMapper modelMapper;

    //Todo 검색 조건 지정 가능하게
    @ApiOperation(value = "알라딘 도서 데이터 저장", notes = "알라딘 도서를 검색 후 디비에 저장한다.")
    @GetMapping(value = "/StorageBook")
    public BaseResponse<List<StorageBookResDto>> storageBook() {
        List<Book> books = bookService.storageBook();
        //entity -> dto
        List<StorageBookResDto> resultList = new ArrayList<>(Arrays.asList(modelMapper.map(books, StorageBookResDto[].class)));
        return new BaseResponse<List<StorageBookResDto>>(resultList);
    }

    @ApiOperation(value = "도서 검색하기", notes = "도서를 검색하여 특정 도서 정보를 얻는다.")
    @GetMapping(value = "/SearchBook")
    public BaseResponse<Object> searchBook(@RequestParam String searchWord, @RequestParam String category) {
        Book searchResults = bookService.searchBook(searchWord, category);
        return new BaseResponse<>(new SearchBookResDto(searchResults.getBookIdx(), searchResults.getBookName(), searchResults.getThumbnail(), searchResults.getAuthor()));
    }

    @ApiOperation(value = "도서 상세 정보 조회", notes = "특정한 도서의 상세 정보를 조회한다.")
    @GetMapping(value = "/GetBookDetail")
    public BaseResponse<Object> getBookDetail(@RequestParam Long id, @RequestParam Long bookIdx) {
        Book bookDetail = bookService.getBookDetail(id, bookIdx);
        return new BaseResponse<>(new GetDetailResDto(bookDetail.getBookIdx(), bookDetail.getBookName(),
                bookDetail.getAuthor(), bookDetail.getThumbnail(), bookDetail.getCategory(),
                bookDetail.getReleaseDate(), bookDetail.getPublisher(), bookDetail.getIntroduction()));
    }

    @ApiOperation(value = "도서 좋아요", notes = "특정 도서 좋아요하기")
    @GetMapping(value = "/LikeBook")
    public BaseResponse<Object> likeBook(@RequestParam Long id, @RequestParam Long bookIdx) {
        Book bookDetail = bookService.getBookDetail(id, bookIdx);
        return new BaseResponse<>(new GetDetailResDto(bookDetail.getBookIdx(), bookDetail.getBookName(),
                bookDetail.getAuthor(), bookDetail.getThumbnail(), bookDetail.getCategory(),
                bookDetail.getReleaseDate(), bookDetail.getPublisher(), bookDetail.getIntroduction()));
    }
}
