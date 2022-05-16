package com.vika.way.pre.mapstruct;

import com.vika.way.pre.reflection.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author tangjiawei
 * @Date 2020/8/27
 */
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /**
     * 转换
     *
     * @param person
     * @return
     */
    @Mappings(@Mapping(target = "high", ignore = true))
    User toUser(Person person);
}
