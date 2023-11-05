package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Winning {
    private final List<Integer> numbers;
    private final int bonus;

    private static final int start = 1;
    private static final int end = 45;
    private static final int size = 6;

    public Winning(List<Integer> numbers, int bonus) {
        checkNumberLength(numbers);
        checkNumberRange(numbers);
        checkBonusRange(bonus);
        checkDuplicate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void checkNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private void checkBonusRange(int bonus) {
        checkRange(bonus);
    }

    private void checkRange(int num) throws IllegalArgumentException {
        if ((num < start) || (num > end)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers, int bonus) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

}
