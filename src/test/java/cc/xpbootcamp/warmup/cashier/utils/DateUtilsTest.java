package cc.xpbootcamp.warmup.cashier.utils;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilsTest {
    Date date;

    @Before
    public void init() {
        date = new Date(2020 - 1900, 1, 19);
    }

    @Test
    public void should_return_correct_formatted_string_when_format_give_a_invalid() {
        assertEquals(DateUtils.format(date), "2020年2月19日 星期三");
    }

    @Test
    public void should_return_true_when_verify_is_wednesday_give_a_valid() {
        assertTrue(DateUtils.isWednesday(date));
    }

    @Test
    public void should_return_true_when_verify_is_wednesday_give_a_invalid() {
        date = new Date(2020 - 1900, 1, 20);
        assertFalse(DateUtils.isWednesday(date));
    }
}
