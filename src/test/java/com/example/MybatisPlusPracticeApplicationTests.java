package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mapper.BookMapper;
import com.example.pojo.Book;
import com.example.pojo.query.BookQuery;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;

@SpringBootTest
class MybatisPlusPracticeApplicationTests {
    @Autowired
    private BookMapper mapper;

    @Test
    public void TestBookMapper() {
//        IPage page =new Page(1,2);
//        QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
//        wrapper.lambda().lt(Book::getId,5);
//        wrapper.lambda().gt(Book::getId,1);
//        IPage res = mapper.selectPage(page,wrapper);
//        System.out.println(res.getRecords());

        BookQuery bookQuery=new BookQuery();
        bookQuery.setId(3L);
        bookQuery.setId2(6L);
        System.out.println("nice");

        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(Book::getId,bookQuery.getId());
        queryWrapper.gt(Book::getId,bookQuery.getId2());
        System.out.println(mapper.selectOne(queryWrapper));
    }

}
