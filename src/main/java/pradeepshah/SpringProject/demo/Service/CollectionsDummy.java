package pradeepshah.SpringProject.demo.Service;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.ListIterator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsDummy {

   public CollectionsDummy(){
        // constructor
    }

    public void listCollection(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(0, 100);
        list1.add(1, 200);
        list1.add(2, 300);
        list1.add(3, 400);

        List<Integer> list2  = new ArrayList<>();
        list2.add(0, 4);
        list2.add(1,5);
        list2.add(1,6);

        list1.addAll(1, list2);
        System.out.println("before replacing list1 element");
        list1.forEach((Integer val) -> System.out.println(val));
        list1.replaceAll((Integer val) -> 2 * val);
        System.out.println("after replacing list1 element to 1*val");
        list1.forEach((Integer val) -> System.out.println(val));

        //sorting using custom comparator
        list1.sort((Integer val1, Integer val2)->val1-val2);
        System.out.println("after sort");
        list1.forEach((Integer val) -> System.out.println(val));
        list1.set(2,102);
        System.out.println("after set method");
        list1.forEach((Integer val) -> System.out.println(val));
        list1.remove(2);
        System.out.println("after set remove method");
        list1.forEach((Integer val) -> System.out.println(val));

        //Traversing forward direction
        ListIterator<Integer> iterator = list1.listIterator();

        while(iterator.hasNext()){
            int val = iterator.next();
            System.out.println("has next index: " + iterator.nextIndex() + " previous index: " + iterator.previousIndex());
            if(val == 5){
                iterator.add(7);
            }
        }

    }
    public void linkedListCollect(){
        // this implement, deque and list interface
        LinkedList<Integer> linkedList = new LinkedList<>();

        // using deque functionality
        linkedList.addFirst(13);
        linkedList.addFirst(12);
        linkedList.addLast(14);
        linkedList.addLast(15);
        System.out.println("after deque functionality");
        linkedList.forEach((Integer val) -> System.out.println(val));
        // using list functionality
        linkedList.add(3,10);
        linkedList.add(4,10);

        System.out.println("after list functionality");
        linkedList.forEach((Integer val) -> System.out.println(val));
        // list and linked list are not thread safe
        // but vector is thread safe
    }

    public synchronized void mapCollection(){
    }

    //introduced with java8
    //it is like a pipeline, through which our collection elements pass through
    // useful when dealing with bulk processing
    // while elements pass through the pipeline it can perform various operations

    public void streamProperties(){
       System.out.println("tueooepd");
        Integer[] arr = {4,3,6,6,10,9};
        Stream<Integer> streamArr = Arrays.stream(arr).distinct().
                peek((Integer val) -> System.out.println("tueooepd " +  val )).
                sorted().peek((Integer val) -> System.out.println("tueooepd2 " +  val ));
        List<Integer> list1 = streamArr.toList();
        System.out.println("tueooepd");

        Stream<Integer> stream2 = Arrays.asList(8,39,493,4).stream();
        Stream<Integer> stream3 = Stream.of(39,493,494,546);

        // creating stream using stream builder
        Stream.Builder<Integer> streamBuilder4 = Stream.builder();
        streamBuilder4.add(93).add(40).add(30);
        Stream<Integer> stream4 = streamBuilder4.build();


        // intermediate operations like: sorted, filter, map, flatmap
        Stream<Integer> stream5 = Stream.of(39,493,494,546);
        Stream<Integer> filteredStream5 = stream5.filter((Integer val)->val < 500);
        List<Integer> filtedList5 = filteredStream5.toList();

        List<Integer> filtedList6 = filtedList5.stream().map((Integer val)->val*1).toList();

        List<List<String>> listComplex = Arrays.asList(
                Arrays.asList("pradeep", "depil","mohini","kiran"),
                Arrays.asList("pradeep2", "depil","mohini","kiran"),
                Arrays.asList("pradeep3", "depil","mohini","kiran")
        );

        List<String> listOfNamesFlatten = listComplex.stream().flatMap((List<String> names)->names.stream()).toList();

        // stream().mapToInt(), mapToDouble,mapToLong helps to work with primitive data types int, double, long data
        Optional<Integer> stream5d = filtedList5.stream()
                .skip(new Random().nextInt(filtedList5.size())) // skip n elements,
                // then randomly pick the elements from 0 to n-1
                .findFirst();
        System.out.println("random value: " + stream5d.get());

        //  parallelStream() for parallel stream processing,
        // task submission and parallel processing : uses Fork-Join Pool Technique
        // it takes very less time to go through the elements
    }
}
