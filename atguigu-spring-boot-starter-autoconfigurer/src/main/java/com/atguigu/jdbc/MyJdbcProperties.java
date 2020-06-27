package com.atguigu.jdbc;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "login")
public class MyJdbcProperties {

   private String classname;
   private String url;
   private String username;
   private String password;
   private String mapper_location;

    public String getMapper_location() {
        return mapper_location;
    }

    public void setMapper_location(String mapper_location) {
        this.mapper_location = mapper_location;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
