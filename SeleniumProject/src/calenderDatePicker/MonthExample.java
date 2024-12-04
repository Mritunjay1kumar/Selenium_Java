package calenderDatePicker;

import java.time.Month;

public class MonthExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Month month = Month.JANUARY;

        Month twoMonthsLater = month.plus(2); // MARCH
        Month threeMonthsEarlier = month.minus(3); // OCTOBER

        System.out.println("Two months later: " + twoMonthsLater);
        System.out.println("Three months earlier: " + threeMonthsEarlier);

	}

}
