package com.vika.way.spring.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author chenwei.tjw
 * @date 2022/12/20
 **/
@Component
public class ParserFactory {

    @Autowired
    private Map<String, Iparser> parserMap;

    @Autowired
    private List<Iparser> parserList;

    @Autowired
    private ParserConfiguration parserConfiguration;

    @PostConstruct
    public void listParser() {
        System.out.println("parserMap:");
        if (parserMap != null) {
            for (Entry<String, Iparser> entry : parserMap.entrySet()) {
                System.out.println(entry.getKey() + entry.getValue());
            }
        }
        System.out.println(parserMap.get("CATEGORY_ID"));
        System.out.println("parserList:");
        if (parserList != null) {
            for (Iparser iparser : parserList) {
                System.out.println(iparser);
            }
        }
    }
}
