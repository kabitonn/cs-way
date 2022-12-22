package com.vika.way.spring.weaver.constans;

/**
 * 编织器执行语言
 *
 * @author chenwei.tjw
 * @date 2022/10/26
 **/
public enum WeaverExecuteLangEnum {
    QL_EXPRESS("QLExpress脚本，语法：https://github.com/alibaba/QLExpress#%E4%B8%89%E8%AF%AD%E6%B3%95%E4%BB%8B%E7%BB%8D"),
    GROOVY("Groovy脚本，语法：http://groovy-lang.org/documentation.html#languagespecification"),
    SpEL("SpEL脚本，语法：https://docs.spring.io/spring-framework/docs/4.3.25.RELEASE/spring-framework-reference/html/expressions.html");

    WeaverExecuteLangEnum(String description){
        this.description=description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
