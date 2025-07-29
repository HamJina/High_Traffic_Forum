package high.traffic.forum.view.service;

import high.traffic.forum.view.entity.ArticleViewCount;
import high.traffic.forum.view.repository.ArticleViewCountBackUpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleViewCountBackUpProcessor {
    private final ArticleViewCountBackUpRepository articleViewCountBackUpRepository;

    @Transactional
    public void backUp(Long articleId, Long viewCount) {
        int result = articleViewCountBackUpRepository.updateViewCount(articleId, viewCount);

        if (result == 0) {
            articleViewCountBackUpRepository.findById(articleId)
                    .ifPresentOrElse(
                            ignored -> {},
                            () -> { // 존재하면 아무것도 안함
                                // 존재하지 않으면 새로 삽입
                                articleViewCountBackUpRepository.save(
                                        ArticleViewCount.init(articleId, viewCount)
                                );
                            }
                    );
        }
    }

}
