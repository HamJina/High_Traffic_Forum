package high.traffic.forum.hotarticle.service;

import high.traffic.forum.hotarticle.repository.ArticleCommentCountRepository;
import high.traffic.forum.hotarticle.repository.ArticleLikeCountRepository;
import high.traffic.forum.hotarticle.repository.ArticleViewCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
// 인기글 점수 계산
public class HotArticleScoreCalculator {
    private final ArticleLikeCountRepository articleLikeCountRepository;
    private final ArticleViewCountRepository articleViewCountRepository;
    private final ArticleCommentCountRepository articleCommentCountRepository;

    // 가중치 상수 설정
    private static final long ARTICLE_LIKE_COUNT_WEIGHT = 3;
    private static final long ARTICLE_COMMENT_COUNT_WEIGHT = 2;
    private static final long ARTICLE_VIEW_COUNT_WEIGHT = 1;

    public long calculate(Long articleId) {
        Long articleLikeCount = articleLikeCountRepository.read(articleId);
        Long articleViewCount = articleViewCountRepository.read(articleId);
        Long articleCommentCount = articleCommentCountRepository.read(articleId);

        return articleLikeCount * ARTICLE_LIKE_COUNT_WEIGHT
                + articleViewCount * ARTICLE_VIEW_COUNT_WEIGHT
                + articleCommentCount * ARTICLE_COMMENT_COUNT_WEIGHT;
    }
}