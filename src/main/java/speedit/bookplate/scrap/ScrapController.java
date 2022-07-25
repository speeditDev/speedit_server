package speedit.bookplate.scrap;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Scrap"})
@RequiredArgsConstructor
@RestController
@RequestMapping
public class ScrapController {

    /*
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
    }*/
}
