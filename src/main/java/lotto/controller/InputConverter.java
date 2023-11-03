package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputConverter {
    public static int convertPrice(String inputPrice) {
        int price = Integer.parseInt(inputPrice);
        return price;
    }

    public static List<Integer> convertWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(inputWinningNumber, ",");
        while(st.hasMoreTokens()) {
            int winningNumber = Integer.parseInt(st.nextToken());
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

}
