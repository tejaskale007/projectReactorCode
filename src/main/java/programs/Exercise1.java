package programs;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("Printing All no: ");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("Printing no. less than 5: ");
        StreamSources.intNumbersStream().filter(n -> n < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        AtomicInteger counter = new AtomicInteger();
        counter.set(0);
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .forEach(
                        n -> {
                            counter.getAndIncrement();
                            if (counter.get() == 2) {
                                System.out.println(n);
                            }
                            if (counter.get() == 3)
                                System.out.println(n);
                        });

        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5 :: Alternative solution");
        StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        Integer firstNoGreaterThan5 = StreamSources.intNumbersStream().filter(n -> n > 5).findFirst().orElse(-1);
        System.out.println(firstNoGreaterThan5);

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().forEach(name -> System.out.println(name.getFirstName()));

        System.out.println("Print first names of all users in userStream:: Alternative Solution");
        StreamSources.userStream().map(User::getFirstName).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        List<User> userList = StreamSources.userStream().collect(Collectors.toList());
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(0);
        StreamSources.intNumbersStream().forEach(n -> {
            if (atomicInteger.get() < userList.size()) {
                User user = userList.get(atomicInteger.get());
                if (n == user.getId()) {
                    System.out.println(user.getFirstName());
                }
                atomicInteger.getAndIncrement();
            }
        });

        System.out.println("Print first names in userStream for users that have IDs from number stream :: Alternate Solution");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(
                        id -> id == user.getId()))
                .forEach(System.out::println);

    }

}
