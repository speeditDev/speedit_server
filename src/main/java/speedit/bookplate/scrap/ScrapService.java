package speedit.bookplate.scrap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScrapService {

    /*
    private final ScrapRepository scrapRepository;
    private final FeedRepository feedRepository;

    @Transactional
    public Scrap scrapFeed(ScrapResDto scrapResDto) {
        Feed feed = feedRepository.findById(scrapResDto.getFeedIdx()).orElseThrow();
        Scrap scrap = Scrap.createScrap(feed);
        return scrapRepository.save(scrap);
    }

    @Transactional
    public Scrap cancelScrap(CancelScrapReqDto cancelScrapReqDto) {
        Scrap scrap = scrapRepository.findById(cancelScrapReqDto.getScrapIdx()).orElseThrow();
        scrap.setStatus(false);
        return scrap;
    }*/
}
