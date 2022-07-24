package speedit.bookplate.bookcategory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import speedit.bookplate.book.dto.StorageBookResDto;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.book.repository.BookRepository;
import speedit.bookplate.bookcategory.entity.BookCategory;
import speedit.bookplate.bookcategory.repository.BookCategoryRepository;
import speedit.bookplate.config.BaseResponse;

import java.util.List;
import java.util.Set;

@Api(tags = {"BookCategory"})
@RequiredArgsConstructor
@RestController
@RequestMapping
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;
    private final BookCategoryRepository bookCategoryRepository;
    private final BookRepository bookRepository;

    //Todo 검색 조건 지정 가능하게
    @ApiOperation(value = "북 카테고리 추가 및 조회", notes = "스피딧 북 카테고리를 추가한 후 조회한다.")
    @GetMapping(value = "/SetCategory")
    public List<BookCategory> setCategory() {
        BookCategory a = bookCategoryService.addCategory();
        Set<String> set = a.getBookCategory().keySet();
//        Book b = Book.settingCategory(set);
        return bookCategoryRepository.findAll();
    }
}
