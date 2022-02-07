package site.metacoding.covid19;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Items {
    private List<Item> item;

    @AllArgsConstructor
    @Data
    class Item {
        private int accExamCnt; // 누적 의심신고 검사자
        private String createDt; // 등록일시분초
        private int deathCnt; // 사망자 수
        private int decideCnt; // 확진자 수
        private int seq; // 게시글 번호(감염현황 고유값)
        private int stateDt; // 기준일
        private String stateTime; // 기준시간
        private String updateDt; // 수정일시분초
    }
}
