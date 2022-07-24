package speedit.bookplate.feed;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.book.repository.BookRepository;
import speedit.bookplate.feed.dto.*;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.feed.entity.Feed;

import javax.validation.Valid;

@Api(tags = {"2. Feed"})
@RequiredArgsConstructor
@RestController
@RequestMapping
public class FeedController {

    private final FeedService feedService;
    private final BookRepository bookRepository;

    @ApiOperation(value = "피드 작성하기", notes = "문장정보, 도서 정보, 피드에 대한 의견, 피드 배경색, 나만 보기 여부를 입력해서 새로운 피드를 생성한다.")
    @PostMapping(value = "/RegisterFeed")
    public BaseResponse<Object> registerFeed(@RequestBody @Valid RegFeedReqDto regFeedRequestDto) throws Exception {
        Feed registeredFeed = feedService.registerFeed(regFeedRequestDto);
        return new BaseResponse<Object>(new RegFeedResDto(registeredFeed.getFeedIdx(), registeredFeed.getStatus(),
                registeredFeed.getBook().getBookName(), registeredFeed.getContents(), registeredFeed.getOpinion(),
                registeredFeed.getColor(), registeredFeed.getIsPrivate(), registeredFeed.getCreatedAt()));
    }

    @ApiOperation(value = "피드 삭제하기", notes = "특정한 피드를 삭제한다.")
    @PatchMapping(value = "/DeleteFeed")
    public BaseResponse<Object> deleteFeed(@RequestBody @Valid DelFeedReqDto delFeedRequestDto) throws Exception {
        Feed deletedFeed = feedService.deleteFeed(delFeedRequestDto);
        return new BaseResponse<Object>(new DelFeedResDto(deletedFeed.getFeedIdx(), deletedFeed.getStatus(),deletedFeed.getCreatedAt(), deletedFeed.getUpdatedAt()));
    }

    @ApiOperation(value = "피드 수정하기", notes = "특정한 피드 정보를 수정한다.")
    @PatchMapping(value = "/AmendFeed")
    public BaseResponse<Object> amendFeed(@RequestBody @Valid AmdFeedReqDto amdFeedRequestDto) throws Exception {
        Feed amendedFeed = feedService.amendFeed(amdFeedRequestDto);
        return new BaseResponse<Object>(new AmdFeedResDto(amendedFeed.getFeedIdx(),amendedFeed.getStatus(),
                amendedFeed.getContents(), amendedFeed.getBook().getBookName(),
                amendedFeed.getOpinion(), amendedFeed.getColor(), amendedFeed.getIsPrivate(),amendedFeed.getCreatedAt(),amendedFeed.getUpdatedAt()));
    }

    @ApiOperation(value = "피드 좋아요", notes = "특정 피드 좋아요한다.")
    @PatchMapping(value = "/LikeFeed")
    public BaseResponse<Object> likeFeed(@RequestBody @Valid AmdFeedReqDto amdFeedRequestDto) throws Exception {
        Feed amendedFeed = feedService.amendFeed(amdFeedRequestDto);
        return new BaseResponse<Object>(new AmdFeedResDto(amendedFeed.getFeedIdx(),amendedFeed.getStatus(),
                amendedFeed.getContents(), amendedFeed.getBook().getBookName(),
                amendedFeed.getOpinion(), amendedFeed.getColor(), amendedFeed.getIsPrivate(),amendedFeed.getCreatedAt(),amendedFeed.getUpdatedAt()));
    }

    @ApiOperation(value = "피드 차단하기", notes = "차단한 유저에게 해당 피드가 노출 되지 않게 한다.")
    @PatchMapping(value = "/BlockFeed")
    public BaseResponse<Object> blockFeed(@RequestBody @Valid AmdFeedReqDto amdFeedRequestDto) throws Exception {
        Feed amendedFeed = feedService.amendFeed(amdFeedRequestDto);
        return new BaseResponse<Object>(new AmdFeedResDto(amendedFeed.getFeedIdx(),amendedFeed.getStatus(),
                amendedFeed.getContents(), amendedFeed.getBook().getBookName(),
                amendedFeed.getOpinion(), amendedFeed.getColor(), amendedFeed.getIsPrivate(),amendedFeed.getCreatedAt(),amendedFeed.getUpdatedAt()));
    }

    @ApiOperation(value = "피드 신고하기", notes = "신고한 유저에게 해당 피트가 노출 되지 않게 한다.")
    @PatchMapping(value = "/ReportFeed")
    public BaseResponse<Object> reportFeed(@RequestBody @Valid AmdFeedReqDto amdFeedRequestDto) throws Exception {
        Feed amendedFeed = feedService.amendFeed(amdFeedRequestDto);
        return new BaseResponse<Object>(new AmdFeedResDto(amendedFeed.getFeedIdx(),amendedFeed.getStatus(),
                amendedFeed.getContents(), amendedFeed.getBook().getBookName(),
                amendedFeed.getOpinion(), amendedFeed.getColor(), amendedFeed.getIsPrivate(),amendedFeed.getCreatedAt(),amendedFeed.getUpdatedAt()));
    }
}
