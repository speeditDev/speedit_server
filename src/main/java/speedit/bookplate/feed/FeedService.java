package speedit.bookplate.feed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.feed.dto.AmdFeedReqDto;
import speedit.bookplate.feed.dto.DelFeedReqDto;
import speedit.bookplate.feed.dto.RegFeedReqDto;
import speedit.bookplate.book.repository.BookRepository;
import speedit.bookplate.feed.entity.Feed;
import speedit.bookplate.feed.entity.enumTypes.Status;
import speedit.bookplate.feed.repository.FeedRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Feed registerFeed(RegFeedReqDto regFeedRequestDto) {
        Book book = bookRepository.findById(regFeedRequestDto.getBookIdx()).orElseThrow();
        Feed feed = Feed.createFeed(regFeedRequestDto.getContents(),book,regFeedRequestDto.getOpinion(),regFeedRequestDto.getColor(),regFeedRequestDto.getIsPrivate());
        return feedRepository.save(feed);
    }

    @Transactional
    public Feed deleteFeed(DelFeedReqDto delFeedRequestDto) {
        Feed feed = feedRepository.findById(delFeedRequestDto.getFeedIdx()).orElseThrow();
        feed.setStatus(Status.N);
        return feed;
    }

    @Transactional
    public Feed amendFeed(AmdFeedReqDto amdFeedRequestDto) {
        Feed feed = feedRepository.findById(amdFeedRequestDto.getFeedIdx()).orElseThrow();
        speedit.bookplate.book.entity.Book book = bookRepository.findById(amdFeedRequestDto.getBookIdx()).orElseThrow();
        feed.setContents(amdFeedRequestDto.getContents());
        feed.setBook(book);
        feed.setOpinion(amdFeedRequestDto.getOpinion());
        feed.setColor(amdFeedRequestDto.getColor());
        feed.setIsPrivate(amdFeedRequestDto.getIsPrivate());
        return feed;
    }
}
