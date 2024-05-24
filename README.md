# SI_2024_lab2_223027
Ivan Andonov 223027
2. CONTROL FLOW GRAPH 

![cfgLAB2fi](https://github.com/IvanAndonov72/SI_2024_lab2_223027/assets/137835000/faaf3efc-94e8-4ef0-a808-5fc75e55ec4c)


3. Одредуванје на цикломатската комплексност може да се изврши на 3 начини и тоа:
   Број на ребра - број на јазли + 2
   Број на региони
   Број на предикатни јазли + 1
   Kако и да пресметаме добиваме дека цикломатската комплексност е 10.

4. package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void checkCart() {
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, () ->  SILab2.checkCart(null,100));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        boolean result= SILab2.checkCart(List.of(new Item(null, "123", 100, 0.1f)),100);
        assertTrue(result);

        ex=assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("bilosto", null, 100, 0.1f)),100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("ime","abc",300, 0)),100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        boolean result2= SILab2.checkCart(List.of(new Item("something", "123", 400, 0)),100);
        assertFalse(result2);

        boolean result3= SILab2.checkCart(List.of(new Item("ime","025",500, 0.1f)),100);
        assertTrue(result3);
    }
}

Ова се тест случаевите кои ги избрав така што сите гранки се покриени од кодот. Првиот тест јасно е дека го покрива првиот exception 
   
