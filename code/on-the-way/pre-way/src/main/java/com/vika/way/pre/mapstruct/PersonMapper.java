package com.vika.way.pre.mapstruct;

import com.vika.way.pre.reflection.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author tangjiawei
 * @Date 2020/8/27
 */
@Mapper
public interface PersonMapper extends BaseConverter {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /**
     * 转换
     *
     * @param person
     * @return
     */
    @Mappings({@Mapping(target = "high", ignore = true),
            @Mapping(target = "attribute", qualifiedByName = "toJson"),
            @Mapping(target = "advances", qualifiedByName = "list2String")})
    User toUser(Person person);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<User> convertList(List<Person> personList);
}
