package speedit.bookplate.scrap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feed.repository.FeedRepository;
import speedit.bookplate.scrap.dto.CancelScrapReqDto;
import speedit.bookplate.scrap.dto.ScrapReqDto;
import speedit.bookplate.scrap.dto.ScrapResDto;
import speedit.bookplate.scrap.entity.Scrap;
import speedit.bookplate.scrap.repository.ScrapRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ScrapService {


    private final ScrapRepository scrapRepository;
    private final FeedRepository feedRepository;

    @Transactional
    public Scrap scrapFeed(ScrapReqDto scrapReqDto) {
        Feed feed = feedRepository.findById(scrapReqDto.getFeedIdx()).orElseThrow();
        Scrap scrap = Scrap.createScrap(feed);
        return scrapRepository.save(scrap);
    }

    @Transactional
    public Scrap cancelScrap(CancelScrapReqDto cancelScrapReqDto) {
        Scrap scrap = scrapRepository.findById(cancelScrapReqDto.getScrapIdx()).orElseThrow();
        scrap.setStatus(false);
        return scrap;
    }
}
