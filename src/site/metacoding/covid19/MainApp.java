package site.metacoding.covid19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("- 코로나 현황 범위를 입력하세요.");
        System.out.println("=============================");
        System.out.println("ex)20220110 시작일");
        String startDate = sc.nextLine();
        System.out.println("=============================");
        System.out.println("ex)20220115 종료일");
        String endDate = sc.nextLine();

        // 1. URL
        try {
            StringBuffer addr = new StringBuffer();
            addr.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?");
            addr.append(
                    "serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&");
            addr.append("pageNo=1&");
            addr.append("numOfRows=10&");
            addr.append("startCreateDt=" + startDate + "&");
            addr.append("endCreateDt=" + endDate + "&");
            addr.append("_type=json");

            URL url = new URL(addr.toString());

            // 2. ByteStream 연결
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 3. Buffer
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            // 4. flush
            String responsJson = br.readLine();
            // System.out.println(responsJson);

            // 5. GSON -> 자바 오브젝트로 변경하기
            Gson gson = new Gson();
            ResponseDto dto = gson.fromJson(responsJson, ResponseDto.class);
            // System.out.println(dto);

            // 6. 통신 검증
            if (!dto.getResponse().getHeader().getResultCode().equals("00")) {
                System.out.println("통신 실패" + dto.getResponse().getHeader().getResultMsg());
                return;
            }

            // 7. 프로그램 만들기
            // System.out.println(dto.getResponse().getBody().getItems().getItem().get(0));
            for (int i = dto.getResponse().getBody().getItems().getItem().size() - 1; i >= 0; i--) {
                System.out.println("=============================================");
                System.out.println(
                        "누적 의심신고 검사자 : " + dto.getResponse().getBody().getItems().getItem().get(i).getAccExamCnt());
                System.out.println("등록일시분초 : " + dto.getResponse().getBody().getItems().getItem().get(i).getCreateDt());
                System.out.println("사망자 수 : " + dto.getResponse().getBody().getItems().getItem().get(i).getDeathCnt());
                System.out.println("확진자 수 : " + dto.getResponse().getBody().getItems().getItem().get(i).getDecideCnt());
                System.out
                        .println("게시글 번호(감염현황 고유값) : "
                                + dto.getResponse().getBody().getItems().getItem().get(i).getSeq());
                System.out.println("기준일 : " + dto.getResponse().getBody().getItems().getItem().get(i).getStateDt());
                System.out.println("기준시간 : " + dto.getResponse().getBody().getItems().getItem().get(i).getStateTime());
                System.out.println("수정일시분초 : " + dto.getResponse().getBody().getItems().getItem().get(i).getUpdateDt());
                System.out.println("=============================================");
            }

        } catch (Exception e) {
            e.printStackTrace(); // 오류 추적
        }
    }
}
