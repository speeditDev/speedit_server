package speedit.bookplate.scrap;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.book.BookService;
import speedit.bookplate.book.dto.GetDetailResDto;
import speedit.bookplate.book.dto.SearchBookResDto;
import speedit.bookplate.book.dto.StorageBookResDto;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.book.repository.BookRepository;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.feed.dto.AmdFeedReqDto;
import speedit.bookplate.feed.dto.AmdFeedResDto;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.scrap.dto.CancelScrapReqDto;
import speedit.bookplate.scrap.dto.CancelScrapResDto;
import speedit.bookplate.scrap.dto.ScrapResDto;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.scrap.repository.ScrapRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(tags = {"Scrap"})
@RequiredArgsConstructor
@RestController
@RequestMapping
public class ScrapController {

    private final ScrapService scrapService;

    @ApiOperation(value = "피드 스크랩하기", notes = "특정한 피드를 스크랩한다.")
    @PatchMapping(value = "/ScrapFeed")
    public BaseResponse<Object> scrapFeed(@RequestBody @Valid ScrapResDto scrapResDto) throws Exception {
        Scrap scrapedFeed = scrapService.scrapFeed(scrapResDto);
        return new BaseResponse<Object>(new ScrapResDto(scrapedFeed.getFeed().getFeedIdx(), scrapedFeed.getStatus(), scrapedFeed.getCreatedAt()));
    }

    @ApiOperation(value = "피드 스크랩 취소하기", notes = "특정한 피드 스크랩을 취소한다.")
    @PatchMapping(value = "/CancelScrapFeed")
    public BaseResponse<Object> cancelScrapFeed(@RequestBody @Valid CancelScrapReqDto cancelScrapReqDto) throws Exception {
        Scrap canceledScrapFeed = scrapService.cancelScrap(cancelScrapReqDto);
        return new BaseResponse<Object>(new CancelScrapResDto(canceledScrapFeed.getFeed().getFeedIdx(),
                canceledScrapFeed.getStatus(), canceledScrapFeed.getCreatedAt(), canceledScrapFeed.getUpdatedAt()));
    }
}
