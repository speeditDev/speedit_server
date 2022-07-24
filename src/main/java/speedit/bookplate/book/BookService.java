package speedit.bookplate.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import speedit.bookplate.book.dto.AladinResDto;
import speedit.bookplate.book.dto.Item;
import speedit.bookplate.book.entity.Book;
import speedit.bookplate.book.repository.BookRepository;
import speedit.bookplate.user.repositroy.UserRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<Book> storageBook() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://www.aladin.co.kr")
                .path("/ttb/api/ItemList.aspx")
                .queryParam("ttbkey", "ttbeun9709231746001")
                .queryParam("QueryType", "ItemNewAll")
                .queryParam("MaxResults", 100)
                .queryParam("start", 1)
                .queryParam("SearchTarget", "Book")
                .queryParam("output", "js")
                .queryParam("Version", "20131101")
                .encode()
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity
                .get(uri)
                .build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AladinResDto> searchList = restTemplate.exchange(requestEntity, AladinResDto.class);

        bookRepository.deleteAllInBatch();

        List<Item> itemList = new ArrayList<>(Objects.requireNonNull(searchList.getBody()).getItem());
        if (itemList.size() > 0) {
            for (Item item : itemList) {
                Book book = Book.createBook(item.getTitle(), item.getAuthor(), item.getPublisher(), item.getCategoryName(), item.getCategoryId(), item.getCover(), item.getPubDate());
                bookRepository.save(book);
            }
        }
//        log.info("uri:{}",uri);
//        log.info("searchList:{}",searchList.getBody());
        return bookRepository.findAll();
    }

    //Todo WebFlux 적용 ㅠㅠ
//    @Transactional
//    public java.lang.Object storageBook() {
//        Flux<java.lang.Object> mono = WebClient.builder().baseUrl("http://www.aladin.co.kr/ttb/api/ItemList.aspx")
//                .build().get()
//                .uri(builder -> builder.path("")
//                        .queryParam("ttbkey", "ttbeun9709231746001")
//                        .queryParam("QueryType", "ItemNewAll")
//                        .queryParam("MaxResults", 100)
//                        .queryParam("start", 1)
//                        .queryParam("SearchTarget", "Book")
//                        .queryParam("output", "js")
//                        .queryParam("Version", "20131101")
//                        .build()
//                )
//                .exchangeToFlux(response -> {
//                    Flux<AladinResult> c = response.bodyToFlux(AladinResult.class);
////                    Mono<AladinResult> mono12 = response.bodyToMono(AladinResult.class);
////
//                    List<Item> a  = new ArrayList<>();
//                    a.addAll(c.)
////                    a.addAll(mono12.map(AladinResult::getItem).to);
//
//
////                    try {
////                        a = mono12.map(AladinResult::getItem).toFuture().get();
////                    } catch (InterruptedException | ExecutionException e) {
////                        e.printStackTrace();
////                    }
//
//                    bookRepository.deleteAllInBatch();
//
////                    assert a != null;
//                    if(a.size()>10){
//                        for (Item item : a) {
//                            Book book = Book.createBook(item.getTitle(), item.getAuthor(), item.getPublisher(), item.getCategoryName(), item.getCategoryId());
//                            bookRepository.save(book);
//                        }
//                    }
////                    return response.bodyToMono(AladinResult.class);
//                    return response.bodyToFlux(AladinResult.class);
//                });
//        return mono.block();
//    }

    @Transactional
    public Book searchBook(String searchWord, String category) {
        return bookRepository.findByBookNameContains(searchWord).orElseThrow();
    }

    @Transactional
    public Book getBookDetail(Long id, Long bookIdx) {
        //Todo 은영님 머지 후 User 정보 포함
        return bookRepository.findById(bookIdx).orElseThrow();
    }
}
