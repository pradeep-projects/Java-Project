package pradeepshah.SpringProject.demo.streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Top N Frequent Words
Given a list of words, use Streams to find the top 3 most frequent words.

Input: ["apple", "banana", "apple", "orange", "banana", "apple"]

Output: ["apple", "banana", "orange"]
* */
public class NWordProblem {
    public List<String> findFrequentWords(){
        List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange","banana","apple"));
        Map<String, Integer> mp = new HashMap<>();
        // or other way to save element in map
        words.forEach(a -> mp.merge(a, 1, Integer::sum));
        return mp.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey).toList();
    }

    public Map<Department, List<Employee>> getDeptEmp(){
        List<Employee> list = new ArrayList<>(Arrays.asList(new Employee(1,"kunal", new Department(12,"tech"), 12000 ),
                new Employee(2,"abhishek", new Department(12,"payment"), 12000 ),
                new Employee(3,"tushar", new Department(12,"tech"), 12000 )));
        return list.stream().collect(Collectors.groupingBy(em -> em.dept));
    }

    public Map<Department, Double> getAvgSalaryInEachDep(){
        List<Employee> list = new ArrayList<>(Arrays.asList(new Employee(1,"kunal", new Department(12,"tech"), 12000 ),
                new Employee(2,"abhishek", new Department(13,"payment"), 12000 ),
                new Employee(3,"tushar", new Department(12,"tech"), 10000 )));
       // Map<Department, List<Employee>>  listMap = list.stream().collect(Collectors.groupingBy(em -> em.dept));
        String result = list.stream().map(e -> e.name).collect(Collectors.joining(", "));
        System.out.println(result); // commas seperated names

        return list.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.dept,                      // group key
                        Collectors.averagingDouble(emp -> emp.salary) // downstream collector
                ));
    }

}

