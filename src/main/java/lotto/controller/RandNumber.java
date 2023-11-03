package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandNumber {
    public static List<Integer> makeRandNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public static List<Integer> makeBonusNumber() {
        List<Integer> bonusNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1);
        return bonusNumber;
    }


}
