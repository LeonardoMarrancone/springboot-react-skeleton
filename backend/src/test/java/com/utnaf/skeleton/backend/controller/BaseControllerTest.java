package com.utnaf.skeleton.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;

@SpringBootTest
public class BaseControllerTest {

    @Test
    void testReturnsList()
    {
        BaseController controller = new BaseController();

        ArrayList<String> check = new ArrayList<String>();
        check.add("Alex");
        check.add("Andrea");
        check.add("Davide");
        check.add("Leonardo");

        Assert.isTrue(check.equals(controller.getList()), "Everything works as expected");
    }
}
