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
    @Test
    void conditionTest(){
        //T T T - only situation when the condition is true
//        RuntimeException ex;
//        ex=assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("ime","025",500,0.1f)),100));
//        assertTrue(ex.getMessage().equals("Condition reached!"));

        //T T T

        boolean result= SILab2.checkCart(List.of(new Item("ime","025",500, 0.1f)),100);
        assertTrue(result);

        //T T F
        boolean result3= SILab2.checkCart(List.of(new Item("ime","225",500, 0.1f)),100);
        assertTrue(result3);

        //T F * -here it doesnt matter if the third condition is met because of &&

        boolean result4= SILab2.checkCart(List.of(new Item("something","123",400, 0)),100);
        assertFalse(result4);

        //F * *

        boolean result5= SILab2.checkCart(List.of(new Item("something","123",200, 0)),100);
        assertFalse(result5);
    }
}