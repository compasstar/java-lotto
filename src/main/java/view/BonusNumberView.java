package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BonusNumberView {

    private final List<Integer> numbers;

    public BonusNumberView(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int show() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return validate(input);
    }

    private int validate(String input) {
        int integerInput = validateInteger(input);
        validateRange(integerInput);
        validateDuplicate(integerInput, numbers);
        return integerInput;
    }

    private int validateInteger(String input) {
        int integerInput;
        try {
            integerInput = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("보너스 번호는 하나의 정수 형태이어야 입니다.");
        }
        return integerInput;
    }

    private void validateRange(int integerInput) {
        if (integerInput < 1 || integerInput > 45) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 1이상 45이하 범위의 숫자이어야 합니다.");
        }
    }

    private void validateDuplicate(int integerInput, List<Integer> numbers) {
        if (numbers.contains(integerInput)) {
            throw new IllegalArgumentException("[Error] 중복되는 숫자가 존재합니다.");
       }
    }
}
