package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec07 {
    
    public static void main(String[] args) {
    
        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if (counter >= 10 || country.equalsIgnoreCase("candada")) {
                        sink.complete();
                    }
                    return counter + 1;
                }
        ).log()
                .subscribe(Util.subscriber());
    
    
    }
    
}
