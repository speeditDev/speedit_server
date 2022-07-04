package speedit.bookplate.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import speedit.bookplate.book.dto.searchResult;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {


    @Transactional
    public Object searchBooks(String maxResults) {
        Mono<Object> mono = WebClient.builder().baseUrl("http://www.aladin.co.kr")
                .build().get()
                .uri(builder -> builder.path("/ttb/api/ItemList.aspx")
                        .queryParam("ttbkey", "ttbeun9709231746001")
                        .queryParam("QueryType", "ItemNewAll")
                        .queryParam("MaxResults", maxResults)
                        .queryParam("start", 1)
                        .queryParam("SearchTarget", "Book")
                        .queryParam("output", "xml")
                        .queryParam("Version", "20131101")
                        .build()
                )
                .exchangeToMono(response -> {
                    return response.bodyToMono(searchResult.class);
                });
        return mono.block();
    }
}
