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

Ова се тест случаевите кои ги избрав така што сите гранки се покриени од кодот. Следува табела во excel каде што детално е опишан текот на сите 6 тест случаеви. Со ова може да заклучиме дека навистина секоја гранка од кодот е помината и со извршување на овие тестови и добивање на очекуваниот резултат (како кодот прикажан погоре) се уверуваме дека нашата java задача функционира тотално точно. 


  
![Screenshot (420)](https://github.com/IvanAndonov72/SI_2024_lab2_223027/assets/137835000/5a3e02df-b880-4038-9b1a-52f9e0cb217a)

5.
   @Test
    void conditionTest(){
        //T T T
  
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("ime","025",500,0.1f)),100));
        assertTrue(ex.getMessage().equals("Condition reached!"));

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

  Во првиот тест го земаме случајот каде што сите услови се исплонети односно влегуваме во if условот. Со цел попрецизно да го провериме ова беше извршено со помош на фрлање на exception така што ако пораката одговара на exception-от во условот тогаш дефинитивно сме влегле и сите 3 услови биле исполнети.
  Во вториот случај земаме првите 2 да се точни и 3тиот услов да е грешен. Ова е доволно за да не влеземе во if-от и според нашиот случај треба да добиеме дека крајниот резултат би бил true, така и добивме односно тестот помина.
  Во третиот тест случај зимаме првиот услов да е точен а вториот грешен и со тоа дефинитивно нема да влеземе во условот така што 3тиот дел може да ја има било која вредност или означуваме *
  Во 4тиот и последниот случај зимаме првиот дел да е грешен, каде што одма се осигуруваме дека нема да влеземе во if-от така што понатаму следните 2 дела можат да ја имаат било која вредност true или false па затоа означуваме со *.
   

