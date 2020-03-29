package test;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author wangqimeng
 * @date 2020/1/19 14:02
 */
public class LocalDateTest {

    @Test
    public void calcTwoDateDiff(){
        LocalDate start = LocalDate.of(2019, 7, 28);
        LocalDate end = LocalDate.of(2019, 8, 2);

        System.out.println(Period.between(start, end).getDays()+1);
    }
}
