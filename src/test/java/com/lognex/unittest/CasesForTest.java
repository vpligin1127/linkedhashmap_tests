package com.lognex.unittest;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CasesForTest {

    static Map<Integer, String> dict1 = new LinkedHashMap<>(16, 0.75f, true);
    static {
        dict1.put(1, "First");
        dict1.put(2, "Second");
        dict1.put(3, "Third");
        dict1.put(4, "Fourth");
    }

    static Map<Integer, String> dict2 = new HashMap<>();
    static {
        dict2.put(1, "First");
        dict2.put(2, "Second");
        dict2.put(3, null);
        dict2.put(null, "Error");
    }

    @Test
    public void assertSecondValue() {
        assertEquals("Значение не совпало", "Second", dict1.get(2));
    }

    @Test
    public void checkEmpty() {
        assertFalse("Словарь не заполнен", dict1.isEmpty());
    }

    @Test
    public void checkValuesForNull() {
        assertFalse("Есть пустые значения", dict1.values().contains(null));
    }

    @Test
    public void checkKeysForNull() {
        assertFalse("Есть пустые ключи", dict1.keySet().contains(null));
    }

    @Test
    public void checkForOrder() {
        //Проверка работы параметра AccessOrder: сначала сформирован Set ключей keysOld в том порядке, как они создались
        dict1.forEach((k, v) -> System.out.println(k+"="+v));
        Set keysOld = dict1.keySet();

        //Теперь обратимся к записям словаря: один раз к записи по ключу 1 и два раза к записи по ключу 2
        System.out.println(dict1.get(1)+" "+dict1.get(2)+" "+dict1.get(2));
        //После такого обращения сформируем снова Set ключей keysNew. Они расположатся в нем в порядке, обратном
        //частоте вызова. Ключ 2 будет последним, ключ 1 - предпоследним.

        Set keysNew = dict1.keySet();

        assertFalse("Порядок не изменился", !keysOld.equals(keysNew));

    }

    @Test
    public void checkIterator() {
        //Проверка работы итератора
        //Сформирован список ключей при помощи метода keySet
        //Сравнивается со списком, сформированным по циклу for each
        Object[] keysExpected = dict1.keySet().toArray();
        List<Integer> keysActual = new ArrayList<>();

        dict1.forEach((k, v)-> keysActual.add(k));

        for (int i=0; i<keysExpected.length; i++) {
            assertEquals(keysExpected[i], keysActual.get(i));
        }

        }

    //@Test
    public void clearDicts() {
        dict1.clear();
        dict2.clear();
    }

}
