package programs;

import java.io.IOException;
import java.util.stream.Collector;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().count().subscribe(e->System.out.println("size: " + e));

        // Collect all items of intNumbersFlux into a single list and print it
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().collectList().subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().buffer(2).map(list->list.get(0)+list.get(1)).subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
