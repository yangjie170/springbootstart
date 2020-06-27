package com.atguigu.jdbc;

public class MyJdbcService {

    MyJdbcProperties myJDBCProperties;

    public void helloJDBC(){
        System.out.println("classname"+ myJDBCProperties.getClassname()
                +"password"+ myJDBCProperties.getPassword()
                +"url"+ myJDBCProperties.getUrl()
                +"username"+ myJDBCProperties.getUsername());
    }

    public void myJdbc(){

    }
    public MyJdbcProperties getMyJDBCProperties() {
        return myJDBCProperties;
    }

    public void setMyJDBCProperties(MyJdbcProperties myJDBCProperties) {
        this.myJDBCProperties = myJDBCProperties;
    }
}
