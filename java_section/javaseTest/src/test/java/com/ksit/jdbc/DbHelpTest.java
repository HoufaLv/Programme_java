package com.ksit.jdbc;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DbHelpTest {

    @Test
    public void returnConnection() {
        Connection connection = DbHelp.returnConnection();
    }

    @Test
    public void commonUpdate() {
    }

    @Test
    public void commonQuery() {
        String sql = "select * from message";
    }
}