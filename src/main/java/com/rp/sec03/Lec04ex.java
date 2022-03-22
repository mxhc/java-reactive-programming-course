package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04ex {
    
    public static void main(String[] args) {
    
        Flux.generate(
                    synchronousSink -> {
                        String country = Util.faker().country().name();
                        synchronousSink.next(country);
                        if (country.equalsIgnoreCase("canada")) {
                            synchronousSink.complete();
                        }
                    }
                )
                .subscribe(Util.subscriber("Miletov subskrajber"));
        
        
    }
    
    
}
