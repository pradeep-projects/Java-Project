package pradeepshah.SpringProject.demo.streamApi;


import org.apache.logging.log4j.util.PropertySource;
import org.springframework.util.comparator.Comparators;
import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PracticeStreamApi {

    public static class StreamIntermediateOperationsExample {
        public static void main(String[] args) {
            // List of lists of names
            List<List<String>> listOfLists = Arrays.asList(
                    Arrays.asList("Reflection", "Collection", "Stream"),
                    Arrays.asList("Structure", "State", "Flow"),
                    Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
            );

            // Create a set to hold intermediate results
            Set<String> intermediateResults = new HashSet<>();

            // Stream pipeline demonstrating various intermediate operations
            List<String> result = listOfLists.stream()
                    .flatMap(List::stream)
                    .filter(s -> s.startsWith("S"))
                    .map(String::toUpperCase)
                    .distinct()
                    .sorted()
                    .peek(s -> intermediateResults.add(s))
                    .collect(Collectors.toList());

            // Print the intermediate results
            System.out.println("Intermediate Results:");
            intermediateResults.forEach(System.out::println);

            // Print the final result
            System.out.println("Final Result:");
            result.forEach(System.out::println);

            List<String> strList = Arrays.asList("name","Mohini", "mohini", "mhoini", "pradeep");
            List<String> strDistict = strList.stream().distinct().toList();
            System.out.println("Distinct array elements:" + strDistict);
        }
    }


    public class StreamTerminalOperationsExample {
        public static void main(String[] args) {
            // Sample data
            List<String> names = Arrays.asList(
                    "Reflection", "Collection", "Stream",
                    "Structure", "Sorting", "State"
            );

            // forEach: Print each name
            System.out.println("forEach:");
            names.stream().forEach(System.out::println);

            // collect: Collect names starting with 'S' into a list
            List<String> sNames = names.stream()
                    .filter(name -> name.startsWith("S"))
                    .collect(Collectors.toList());
            System.out.println("\ncollect (names starting with 'S'):");
            sNames.forEach(System.out::println);

            // reduce: Concatenate all names into a single string
            String concatenatedNames = names.stream().reduce(
                    "",
                    (partialString, element) -> partialString + " " + element
            );
            System.out.println("\nreduce (concatenated names):");
            System.out.println(concatenatedNames.trim());

            // count: Count the number of names
            long count = names.stream().count();
            System.out.println("\ncount:");
            System.out.println(count);

            // findFirst: Find the first name
            Optional<String> firstName = names.stream().findFirst();
            System.out.println("\nfindFirst:");
            firstName.ifPresent(System.out::println);

            // allMatch: Check if all names start with 'S'
            boolean allStartWithS = names.stream().allMatch(
                    name -> name.startsWith("S")
            );
            System.out.println("\nallMatch (all start with 'S'):");
            System.out.println(allStartWithS);

            // anyMatch: Check if any name starts with 'S'
            boolean anyStartWithS = names.stream().anyMatch(
                    name -> name.startsWith("S")
            );
            System.out.println("\nanyMatch (any start with 'S'):");
            System.out.println(anyStartWithS);
        }
    }
    static LoggerConfig logger = LoggerConfig.getLoggerInstance();
    public static void basicStreamApi(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        // find even numbers from list
        list.stream().filter(n -> n%2==0).toList().forEach(System.out::println);

        // find maximum numbers from list
        Integer maxValue = list.stream().max(Integer::compare).orElse(null);

        // sort a list

        List<Integer> sortNum = Arrays.asList(1,4,5,9,3,6);

        sortNum.stream().sorted(Comparator.reverseOrder()).toList().forEach(System.out::println);

        // count string with specific prefix
        List<String> countString = Arrays.asList("Lakhan", "Akshay", "Sachan", "Pavan", "Aashish", "Devansh");
        int count = countString.stream().filter(name -> name.startsWith("A")).toList().size();
        System.out.println("count");

        // find non repeated character in a string
        String input = "swiss";
       String str = input.chars().mapToObj(c -> (char) c).filter(c -> input.indexOf(c) == input.lastIndexOf(c)).toString();

       // convert lsit of strings to upperCase
        countString.stream().map(String::toUpperCase).toList().forEach(System.out::println);

        // sum of the numbers in a list
        List<Integer> listOfnum = Arrays.asList(2,4,5,6,9);
        int sum = listOfnum.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // check if any string matches a condition
        boolean contains = countString.stream().anyMatch(s -> s.contains("Lakhan"));

        // find the duplicates elements in the list
        List<Integer> numbers4 = Arrays.asList(4,5,6,5,5,9);

        List<Integer> duplicate = numbers4.stream().filter(num -> numbers4.indexOf(num) != numbers4.lastIndexOf(num)).toList();


        List<Integer> nums5 = Arrays.asList(3,4,5,20,30);
        double average = nums5.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println(average);

        // convert a list of strings into a map with the string as the key adn its length as the value.

        List<String> words = Arrays.asList("mohan", "sohal", "rohan", "tumar", "hula");
        Map<String, Integer> mp = words.stream().collect(Collectors.toMap(word -> word, String::length));
        System.out.println(mp);

        // find 3rd larget element in the list
        int thirdLargest = nums5.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow();
        System.out.println("third largest element: "+ thirdLargest);


        // find all strings that are palindromes in a list
        List<String> list3 = Arrays.asList("aba", "bdce","dht","tttkttt");
        List<String>  palindromeList = list3.stream().filter(word -> word.equals(new StringBuilder(word).reverse().toString())).toList(); // need to understand the String builder
        System.out.println("palindrome list: " + palindromeList);


        // calculate the product of all the numbers in a list using reduce.

        int product = listOfnum.stream().reduce(1, (a,b) -> a * b);
        System.out.println("Product of the elements: " + product);

        int[] arr = {4,9,9,8,8,4};
        List<Integer> arrlist = Arrays.stream(arr).boxed().toList();
        // boxed() converts IntStream to Stream<Integer>
        IntSummaryStatistics states = arrlist.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(states.getAverage());
        System.out.println(states.getMax());
        System.out.println(states.getCount());


        String inputStr = "Java code is very scalable";

        String result = Arrays.stream(inputStr.split(" "))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        listStr -> {
                            Collections.reverse(listStr);
                            return String.join(" ", listStr);
                        }
                ));

        System.out.println(result);



    }

    static int countFinPlatForm(double[] arrival, double[] departure){

        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        int count = 1;

        for(int i=0;i<arrival.length;i++){
            Double arrivalTime = arrival[i];
            if(!minHeap.isEmpty() && minHeap.peek() > arrivalTime){
                minHeap.add(departure[i]);
            }else{
                if(!minHeap.isEmpty()){
                    minHeap.poll();
                }

                minHeap.add(departure[i]);
            }
            logger.info( " minHeap: "  + minHeap);
            count = Math.max(count, minHeap.size());
        }
        return count;
    }

    public static int twoPointerApproach(double[] arrival, double[] departure){
        int i = 0;
        int j = 0;
        int n = arrival.length;
        Arrays.sort(departure); // sort departure time
        int count = 0;
        while(i < n && j < n){
            if(arrival[i] < departure[j]){
                count++;
                i++;
            }else{
                i++;
                j++;
            }
        }
        return count;
    }

    public static class Employee{
        String name;
        int age;
        Double salary;
        Employee(String name, int age, double salary){
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        double getSalary(){
            return salary;
        }
        void setSalary(Double salary){
            this.salary = salary;
        }
    }

    void funStream(){
        String stringLiteral = new String("Hello");
        String st2  = stringLiteral.intern();
        System.out.println("" + st2 + " : " + stringLiteral + (st2.equals(stringLiteral)));

        //Frequency of Each Character in a String
        String strLiteral = "Hello";
        Map<Character, Long> mp = strLiteral.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(ch->ch, Collectors.counting()));
        System.out.println(mp);

        //First Non-Repeating Character and all non repeating characters
        //
        //
        String str = "swiss"; // output: wi
        String nonRepeating = str.chars().mapToObj(ch -> (char) ch)
                .filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(nonRepeating);
        // Shyft - Labs,

        //  Filter Employees with Salary > 50K

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new  Employee("Mohini", 28, 10000));
        employeeList.add(new  Employee("kiran", 24, 51000));
        employeeList.add(new  Employee("dilip", 28, 53000));
        employeeList.add(new  Employee("pradeep", 26, 60000));

        List<Employee> filteredList = employeeList.stream().filter(employee -> employee.salary > 50000).toList();
        filteredList.forEach(employee -> System.out.println(employee.name));

        int sum = Stream.of(50,20,60).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        Set<String> employeeNamesSet = employeeList.stream().map(employee -> employee.name).collect(Collectors.toSet());
        System.out.println(employeeNamesSet);
        Employee maxSalary = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow();
        System.out.println(maxSalary.name);

        List<Integer> list1 = Arrays.asList(3, 6, 80, 30, 40, 80);
        Employee employees = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElseThrow();
        System.out.println("Second highest salary " + employees.name);
        List<Integer> sortedList = list1.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);

        // Count Words in a Sentence
        String words = "Java is a scalable language";
        long count = Arrays.stream(words.split(" ")).count();
        System.out.println(count);

        // Find Duplicate Elements in List
        Set<Integer> duplicate  =  list1.stream().filter(num -> Collections.frequency(list1,num) > 1)
                .collect(Collectors.toSet());
        System.out.println(duplicate);

        // find average
        double avg = list1.stream().collect(Collectors.summarizingInt(num->num)).getAverage();
        System.out.println(avg);

        // Partition Numbers into Even/Odd
        Map<Boolean, Long> partitioned = list1.stream().collect(Collectors.partitioningBy(n -> n%2==0, Collectors.counting()));
        System.out.println(partitioned);
        List<String> words2 = Arrays.asList("Hi","hello" );
        String res = String.join(",", words2);
        String res2 = words2.stream().collect(Collectors.joining(","));

        // longest word in a list
        String longestWord = words2.stream().max(Comparator.comparing(String::length)).orElseThrow();
        System.out.println("longest Word: " + longestWord);

        // smallest Word in a list
        String smallestWord = words2.stream().min(Comparator.comparing(String::length)).orElse("");
        System.out.println("smallest Word: " + smallestWord);

        //
        String words3 = "Java is a scalable language language scalable";
        Map<String,Long> mp1= Arrays.stream(words3.split(" ")).collect(Collectors.groupingBy(word->word, Collectors.counting()));
        System.out.println("freq count " + mp1);

        // parallel stream for performance
        List<Integer> listOfNum = Arrays.asList(2,5,6,7,8,10,9,1,4,3);
        int parallelSum = listOfNum.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("sum " + parallelSum);

        // Check if All Employees Above 18
        boolean allAdults = listOfNum.stream().allMatch(num -> num > 18);
        System.out.println("sum " + allAdults);

        //Distinct Elements in List
        List<Integer> numbers = Arrays.asList(1,1,2,2,3,4,5,6,3);
        List<Integer> distinctNums = numbers.stream().distinct().toList();
        System.out.println("distinct List: " + distinctNums);

        //Top 3 Salaries
        List<Double> top3 = employeeList.stream().map(employee -> employee.salary)
                .sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("Top 3 highest Salary: " + top3);

    }

















    public static void main(String[] args)  {


    }
}
