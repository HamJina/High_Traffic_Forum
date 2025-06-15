package high.traffic.forum.article.service;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PageLimitCalculatorTest {

    @Test
    void calculatePageListTest() {
        calculatePageListTest(1L, 30L, 10L, 301L);
        calculatePageListTest(7L, 30L, 10L, 301L);
        calculatePageListTest(10L, 30L, 10L, 301L);
        calculatePageListTest(11L, 30L, 10L, 601L);
        calculatePageListTest(12L, 30L, 10L, 601L);
    }

    void calculatePageListTest(Long page, Long pageSize, Long movablePageCount, Long expected) {
        Long result = PageLimitCalculator.calculatePageLimit(page, pageSize, movablePageCount);
        assertThat(result).isEqualTo(expected);
    }
}