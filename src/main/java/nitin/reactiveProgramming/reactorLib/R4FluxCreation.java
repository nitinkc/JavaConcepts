package nitin.reactiveProgramming.reactorLib;

import com.utilities.ReactorUtils;
import java.util.List;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class R4FluxCreation {
    public static void main(String[] args) {
        // single emelent flux
        Flux<String> stringFlux = Flux.just(ReactorUtils.faker().animal().name());

        stringFlux.subscribe(
                ReactorUtils.onNext(), ReactorUtils.onError(), ReactorUtils.onComplete());

        // Multi Element Flux
        Flux<String> multiStringFlux =
                Flux.just(
                        ReactorUtils.faker().book().title(),
                        ReactorUtils.faker().book().title(),
                        ReactorUtils.faker().book().title());

        multiStringFlux.subscribe(ReactorUtils.onNext("Subscriber 1"));
        multiStringFlux.subscribe(ReactorUtils.onNext("Subscriber 2"));

        System.out.println("------ From List ------");
        // Flux from ArrayList
        List<String> titles =
                List.of(
                        ReactorUtils.faker().book().title(),
                        ReactorUtils.faker().book().title(),
                        ReactorUtils.faker().book().title());

        Flux<String> fromIterable = Flux.fromIterable(titles);
        fromIterable.subscribe(ReactorUtils.onNext());

        System.out.println("------ From Array ------");
        // Flux from Arrays
        String[] title = {
            ReactorUtils.faker().book().title(),
            ReactorUtils.faker().book().title(),
            ReactorUtils.faker().book().title()
        };
        Flux<String> fromArray = Flux.fromArray(title);
        fromArray.subscribe(ReactorUtils.onNext());

        System.out.println("------ From Streams ------");
        Stream<String> stringStream = titles.stream();
        Flux<String> fromStream = Flux.fromStream(stringStream);
        fromStream.subscribe(ReactorUtils.onNext());

        System.out.println("------ From Range (Integer) ------");
        Flux<Integer> range = Flux.range(6, 5); // Get counts
        range.subscribe(ReactorUtils.onNext());
        Flux<String> rangeNames =
                Flux.range(6, 5).log().map(iterator -> ReactorUtils.faker().book().title()).log();
        rangeNames.subscribe(ReactorUtils.onNext());
    }
}
