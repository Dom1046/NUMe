package codeTest;

import java.util.*;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. 컴퓨터가 고를 세 자리의 서로 다른 숫자 생성
        Set<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < 3) {
            numberSet.add(random.nextInt(9) + 1); // 1부터 9까지의 난수
        }

        List<Integer> computerNumbers = new ArrayList<>(numberSet);

        // 디버깅용: 컴퓨터가 고른 숫자를 출력 (실제 게임에서는 주석 처리)
        System.out.println("컴퓨터가 고른 숫자: " + computerNumbers);

        int attempts = 0;

        while (true) {
            System.out.print("숫자를 입력하세요 (예: 123): ");
            String input = scanner.nextLine();
            attempts++;

            if (input.length() != 3) {
                System.out.println("세 자리 숫자를 입력해야 합니다.");
                continue;
            }

            // 2. 사용자가 입력한 숫자를 리스트로 변환
            List<Integer> userNumbers = new ArrayList<>();
            for (char c : input.toCharArray()) {
                userNumbers.add(Character.getNumericValue(c));
            }

            // 3. 스트라이크와 볼을 계산
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                    strike++;
                } else if (computerNumbers.contains(userNumbers.get(i))) {
                    ball++;
                }
            }

            // 4. 결과 출력
            System.out.println(strike + " 스트라이크, " + ball + " 볼");

            // 5. 승리 조건 확인
            if (strike == 3) {
                System.out.println("축하합니다! " + attempts + "번 만에 맞추셨습니다.");
                break;
            }
        }

        scanner.close();
    }
}


