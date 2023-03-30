package programs;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException().subscribe(System.out::println, t-> System.out.println(t.getMessage()));

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(e -> System.out.println("Error: " + e.getMessage()))//we can log the error when encountered, make an note, it's not going to swollow the error
//                .subscribe(System.out::println);

//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((e,item) -> System.out.println("Error: " + e.getMessage()))//we can log the error when encountered, make a note, and continue the process
//                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(e -> Flux.just(-1,-2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
