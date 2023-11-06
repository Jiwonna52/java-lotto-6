package lotto.exception;

import lotto.model.BonusNumber;
import lotto.model.Number;
import lotto.model.WinningNumber;

import java.util.List;

import static lotto.view.ErrorMessage.*;

public class ExceptionController {

    /*
    public static BonusNumber checkBonusNumberException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        try {
            checkNumberException(bonus);
            checkBonusDuplicateException(numbers, bonus);
            return new BonusNumber(bonus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }*/

    public static WinningNumber checkWinningNumberException(List<Integer> winningNumbers) throws IllegalArgumentException {
        try {
            checkRangeRotate(winningNumbers);
            checkNumberLengthException(winningNumbers);
            checkDuplicate(winningNumbers);
            return new WinningNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void checkNumberException(int num) throws IllegalArgumentException {
        try {
            Number.checkRange(num);
        } catch (IllegalArgumentException e) {
            outOfBoundExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    /*
    public static void checkBonusDuplicateException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        try {
            Number.checkDuplicate(numbers, bonus);
        } catch (IllegalArgumentException e) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
    }*/

    private static void checkNumberLengthException(List<Integer> numbers) throws IllegalArgumentException {
        try {
            WinningNumber.checkNumberLength(numbers);
        } catch (IllegalArgumentException e) {
            notEnoughLengthOfWinningNumbersExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicate(List<Integer> numbers) throws IllegalArgumentException{
        try {
            WinningNumber.checkDuplicate(numbers);
        } catch (IllegalArgumentException e) {
            duplicatedWinningNumbers();
            throw new IllegalArgumentException();
        }
    }

    private static void checkRangeRotate(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            Number.checkRange(number);
        }
    }
}
