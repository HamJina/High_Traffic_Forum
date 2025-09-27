package high.traffic.forum.articleread.service.event.handler;

import high.traffic.forum.articleread.repository.ArticleIdListRepository;
import high.traffic.forum.articleread.repository.ArticleQueryModelRepository;
import high.traffic.forum.articleread.repository.BoardArticleCountRepository;
import kuke.board.common.outboxmessagerelay.Event;
import kuke.board.common.outboxmessagerelay.EventType;
import kuke.board.common.outboxmessagerelay.payload.ArticleDeletedEventPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleDeletedEventHandler implements EventHandler<ArticleDeletedEventPayload> {
    private final ArticleIdListRepository articleIdListRepository;
    private final ArticleQueryModelRepository articleQueryModelRepository;
    private final BoardArticleCountRepository boardArticleCountRepository;

    @Override
    public void handle(Event<ArticleDeletedEventPayload> event) {
        ArticleDeletedEventPayload payload = event.getPayload();
        articleIdListRepository.delete(payload.getBoardId(), payload.getArticleId());
        articleQueryModelRepository.delete(payload.getArticleId());
        boardArticleCountRepository.createOrUpdate(payload.getBoardId(), payload.getBoardArticleCount());
    }

    @Override
    public boolean supports(Event<ArticleDeletedEventPayload> event) {
        return EventType.ARTICLE_DELETED == event.getType();
    }
}

