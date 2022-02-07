package site.metacoding.covid19;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {
    private Response response;

    @AllArgsConstructor
    @Data
    class Response {
        private Header header;
        private Body body;

        @AllArgsConstructor
        @Data
        class Header {
            private String resultCode; // 결과코드
            private String resultMsg; // 결과 메세지
        } // end of Header

        @AllArgsConstructor
        @Data
        class Body {
            private Items items; // 코로나 정보
            private int numOfRows; // 한 페이지 결과 수
            private int pageNo; // 페이지 수
            private int totalCount; // 전체 결과 수

        } // end of Body

    }

}
