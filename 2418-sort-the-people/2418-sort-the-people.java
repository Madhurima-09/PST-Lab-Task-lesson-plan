import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // Helper class to store name and height together
    static class Person {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];

        // Combine names and heights into Person array
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        // Sort in descending order based on height
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // Descending order: compare p2 to p1
                return Integer.compare(p2.height, p1.height);
            }
        });

        // Extract sorted names
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = people[i].name;
        }

        return result;
    }
}