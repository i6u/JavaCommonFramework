package com.witt.ssm.service.impl;

import com.witt.ssm.BaseTest;
import com.witt.ssm.dto.AppointExecution;
import com.witt.ssm.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends BaseTest {

    @Autowired
    BookService bookService;

    @Test
    public void testAppoint() {
        long bookId =  1001;
        long studentId = 123456L;

        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }
}
