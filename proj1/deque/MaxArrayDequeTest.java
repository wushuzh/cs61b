package deque;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    private record Person(String name, int age, double salary) {}

    @Test
    public void testConstrucotrAndGivenComparator() {

        Comparator<Person> nameComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        };

        MaxArrayDeque<Person> mad = new MaxArrayDeque<>(nameComparator);
        mad.addFirst(new Person("Ada", 18, 30_0000));
        mad.addFirst(new Person("Bob", 21, 20_0000));
        mad.addFirst(new Person("Cathy", 19, 15_0000));

        assertEquals("Cathy", mad.max().name());

        Comparator<Person> ageComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        };

        assertEquals("Bob", mad.max(ageComparator).name());

    }

}
