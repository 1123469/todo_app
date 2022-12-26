package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.TodoItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodosMapper extends BaseMapper<TodoItem> {
//    @Select("select * from todos")
//    public List<TodoItem> find();
}
