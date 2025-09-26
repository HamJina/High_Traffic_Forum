package high.traffic.forum.hotarticle.service.eventhandler;
import kuke.board.common.outboxmessagerelay.Event;
import kuke.board.common.outboxmessagerelay.EventPayload;

public interface EventHandler<T extends EventPayload> {
    void handle(Event<T> event);
    boolean supports(Event<T> event);
    Long findArticleId(Event<T> event);
}
