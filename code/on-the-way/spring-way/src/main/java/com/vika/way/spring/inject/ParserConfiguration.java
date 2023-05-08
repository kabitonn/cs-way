package com.vika.way.spring.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenwei.tjw
 * @date 2023/1/9
 **/
@Configuration
public class ParserConfiguration {

    @Bean
    public Iparser defaultParser2() {
        return new DefaultParser();
    }

    @Bean
    public List<Iparser> commonParser() {
        List<Iparser> list = new ArrayList<>();
        list.add(new SpecificParser());
        return list;
    }
}
