package kuke.board.common.outboxmessagerelay.payload;

import kuke.board.common.outboxmessagerelay.EventPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleUnlikedEventPayload implements EventPayload {
    private Long articleLikeId;
    private Long articleId;
    private Long userId;
    private LocalDateTime createdAt;
    private Long articleLikeCount;
}

