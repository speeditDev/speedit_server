package speedit.bookplate.scrap;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.scrap.dto.CancelScrapReqDto;
import speedit.bookplate.scrap.dto.CancelScrapResDto;
import speedit.bookplate.scrap.dto.ScrapReqDto;
import speedit.bookplate.scrap.dto.ScrapResDto;
import speedit.bookplate.scrap.entity.Scrap;

import javax.validation.Valid;

@Api(tags = {"Scrap"})
@RequiredArgsConstructor
@RestController
@RequestMapping
public class ScrapController {

    private final ScrapService scrapService;

    @ApiOperation(value = "피드 스크랩하기", notes = "특정한 피드를 스크랩한다.")
    @PostMapping(value = "/ScrapFeed")
    public BaseResponse<Object> scrapFeed(@RequestBody @Valid ScrapReqDto scrapReqDto) throws Exception {
        Scrap scrapedFeed = scrapService.scrapFeed(scrapReqDto);
        return new BaseResponse<Object>(new ScrapResDto(scrapedFeed.getScrapId(), scrapedFeed.getFeed().getFeedIdx(), scrapedFeed.getStatus(), scrapedFeed.getCreatedAt()));
    }

    @ApiOperation(value = "피드 스크랩 취소하기", notes = "특정한 피드 스크랩을 취소한다.")
    @PatchMapping(value = "/CancelScrapFeed")
    public BaseResponse<Object> cancelScrapFeed(@RequestBody @Valid CancelScrapReqDto cancelScrapReqDto) throws Exception {
        Scrap canceledScrapFeed = scrapService.cancelScrap(cancelScrapReqDto);
        return new BaseResponse<Object>(new CancelScrapResDto(canceledScrapFeed.getScrapId(), canceledScrapFeed.getFeed().getFeedIdx(),
                canceledScrapFeed.getStatus(), canceledScrapFeed.getCreatedAt(), canceledScrapFeed.getUpdatedAt()));
    }
}
