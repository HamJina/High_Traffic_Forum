package high.traffic.forum.articleread.service.event.handler;

import kuke.board.common.outboxmessagerelay.Event;
import kuke.board.common.outboxmessagerelay.EventPayload;

public interface EventHandler<T extends EventPayload> {
    void handle(Event<T> event);
    boolean supports(Event<T> event);
}

