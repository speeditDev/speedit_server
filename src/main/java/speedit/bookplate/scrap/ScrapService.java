package speedit.bookplate.scrap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.book.repository.BookRepository;
import speedit.bookplate.feed.dto.AmdFeedReqDto;
import speedit.bookplate.feed.dto.DelFeedReqDto;
import speedit.bookplate.feed.dto.RegFeedReqDto;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feed.entity.enumTypes.Status;
import speedit.bookplate.feed.repository.FeedRepository;
import speedit.bookplate.scrap.dto.CancelScrapReqDto;
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
    }
}
