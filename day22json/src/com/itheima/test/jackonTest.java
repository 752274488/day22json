package com.itheima.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Person;
import org.junit.Test;

import java.io.FileWriter;
import java.util.*;

public class jackonTest {
    @Test
    public void test1() throws Exception {
        /* JSON解析器：
			* 常见的解析器：Jsonlib，Gson，fastjson，jackson*/
        //将java对象 转换成json字符串
        Person person= new Person();
        person.setAge(22);
        person.setName("张三");
        person.setGender("男");
        //创建jackon的核心对象   ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        /*1. 转换方法：
						* writeValue(参数1，obj):
        参数1：
        File：将obj对象转换为JSON字符串，并保存到指定的文件中
        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
        * writeValueAsString(obj):将对象转为json字符串*/
        String json = mapper.writeValueAsString(person);
       /* System.out.println(json);*/
        /*mapper.writeValue(new File("d://a.txt"),person);*/
        mapper.writeValue(new FileWriter("d://b.txt"),person);
    }

    //jackson  中  1. @JsonIgnore：排除属性。 2. @JsonFormat：属性值得格式化的应用 加在对应的属性上面
    @Test
    public void test2() throws Exception {
        //将java对象 转换成json字符串
        Person person= new Person();
        person.setAge(22);person.setGender("男");
        person.setName("张三");

        person.setBrithday(new Date());
        //创建jackon的核心对象   ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }
    //list集合转换为json
    @Test
    public void test3() throws Exception {

        Person person= new Person();
        person.setAge(22);
        person.setGender("男");
        person.setName("张三");
        person.setBrithday(new Date());

        Person person1= new Person();
        person1.setAge(22);
        person1.setGender("男");
        person1.setName("张三");
        person1.setBrithday(new Date());

        Person person2= new Person();
        person2.setAge(22);
        person2.setGender("男");
        person2.setName("张三");
        person2.setBrithday(new Date());
        List<Person> list= new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person);
        //创建jackon的核心对象   ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
        /*[{"name":"张三","age":22,"gender":"男","brithday":"2019-04-22"},
        {"name":"张三","age":22,"gender":"男","brithday":"2019-04-22"},
        {"name":"张三","age":22,"gender":"男","brithday":"2019-04-22"}]*/
    }
    //map集合转换为json
    @Test
    public void test4() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("name","李四");
        map.put("age",24);
        map.put("gender","女");
        ObjectMapper mapper= new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
        /*{"age":24,"name":"李四","gender":"女"}*/
    }
    //将json 转换为 java对象
    @Test
    public void test5() throws Exception {

        String json="{\"age\":24,\"name\":\"李四\",\"gender\":\"女\"}";
        ObjectMapper mapper= new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
