import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CasesForTest {

    static Map<Integer, String> dict1 = new LinkedHashMap<Integer, String>();
    static {
        //dict1.put(1, "First");
        //dict1.put(2, "Second");
    }

    @Test
    public void test1() {
        System.out.println(dict1);
        assertEquals("Значение не совпало", "Second", dict1.get(2));
    }

    @Test
    public void test2() {
        assertEquals("Значение не совпало", "Second", dict1.get(2));
    }

    @Test
    public void test3() {
        assertFalse("Значения не заполнены", dict1.isEmpty());
    }


}
