package lotto.controller;

import lotto.model.Lotto;
import java.util.*;

import static lotto.controller.InputConverter.*;
import static lotto.controller.InputHandler.*;
import static lotto.controller.Statistic.*;
import static lotto.controller.lotteryController.*;
import static lotto.controller.winningController.*;
import static lotto.view.Message.*;
import static lotto.view.Print.*;

public class Play {
    private static final int start = 1;
    private static final int end = 45;
    private static final int size = 6;
    public Play() {
        HashMap<Rank, Integer> result = new HashMap<>();
        int price = createPrice();
        int count = calLottoCount(price);
        printBoughtLottoCount(count);
        List<Lotto> lottery = rotateLotteryCount(count);
        printLottoRotate(lottery);
        List<Integer> winningNumbers = createWinningNumber();
        int bonus = createBonusNumber(winningNumbers);

        messageAboutWinningStatistic();

        result = createResult(lottery, winningNumbers, bonus);
        printResultRank(result);

        int sumPrize = calSumPrize(result);
        double rateMean = calRate(sumPrize, price);
        printMean(rateMean);
    }

    public static int createPrice() {
        int price = 0;
        while(true) {
            messageAboutPrice();
            String tmpPrice = inputPrice();
            try {
                price = convertPrice(tmpPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
        return price;
    }

    public static List<Integer> createWinningNumber() {
        List<Integer> winningNumbers = new ArrayList<>();
        while(true) {
            try {
                messageAboutUserLottoNumber();
                String tmpWinningNumbers = inputWinningNumbers();
                winningNumbers = convertWinningNumber(tmpWinningNumbers);
                checkWinningNumbersLength(winningNumbers);
                rotateWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
                //e.getMessage();
            }
        }
        System.out.println();
        return winningNumbers;
    }

    public static int createBonusNumber(List<Integer> numbers) {
        int bonus = 0;
        while(true) {
            try {
                messageAboutUserBonusNumber();
                String tmpBonusNumber = inputBonusNumber();
                bonus = convertBonusNumber(tmpBonusNumber);
                checkRange(bonus);
                checkDuplicate(numbers, bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
        return bonus;
    }

    public static void checkWinningNumbersLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    public static void rotateWinningNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        for (int number : winningNumbers) {
            checkRange(number);
        }
    }
    public static void checkRange(int num) throws IllegalArgumentException{
        if ((num < start) || (num > end)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

}
