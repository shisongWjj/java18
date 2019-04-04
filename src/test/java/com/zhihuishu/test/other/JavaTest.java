package com.zhihuishu.test.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class JavaTest {

    public List<Employee> employees = Arrays.asList(
            new Employee("张三",9999.99,55),
            new Employee("李四",6666.66,24),
            new Employee("王五",2222.22,36),
            new Employee("赵六",4444.44,41),
            new Employee("田七",7777.77,18)
    );


   /* public static void main(String[] args) {
        //jdk1.7
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("执行线程run1");
            }
        };
        run1.run();

        Runnable run2 = () ->System.out.println("执行线程run2");
        run2.run();
    }*/

   //需求 按照某种条件对员工进行过滤
    //方式一：传统的方式，这种方式极端的不方便，如果当需要按其他方式过滤 还要重新写一个方法，所以就延伸出策略模式来实现
    @Test
    public void test1(){
        List<Employee> employees = filterEmp1(this.employees);
        employees.forEach(
                (x)-> System.out.println(x)
                );

    }

    List<Employee> filterEmp1(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if(employee.getSalary()>5000D){
                emps.add(employee);
            }
        }

        return emps;
    }

    //优化方式一：策略模式
    //这种方法的缺点，每多一次过滤方式，就要创建一个类
    @Test
    public void test2(){
        List<Employee> employees = filterEmp2(this.employees,new FilterSalary());
        employees.forEach(
                (x)-> System.out.println(x)
        );

        System.out.println("------------------------------");

        List<Employee> employees2 = filterEmp2(this.employees,new FilterAge());
        employees2.forEach(
                (x)-> System.out.println(x)
        );
    }

    List<Employee> filterEmp2(List<Employee> list,MyPredicate<Employee> fs){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if(fs.myPredicate(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }

    //优化方式2：匿名内部类
    //缺点 匿名内部类中的无用代码太多，真正有用的source.getSalary()>5000 就这一行代码
    @Test
    public void test3(){
        List<Employee> employees = filterEmp2(this.employees, new MyPredicate<Employee>() {
            @Override
            public Boolean myPredicate(Employee source) {
                return source.getSalary()>5000;
            }
        });
        employees.forEach(
                (x)-> System.out.println(x)
        );
    }

    //优化方式3：lambda表达式
    @Test
    public void test4(){
        List<Employee> employees = filterEmp2(this.employees, (x) -> x.getSalary()>5000);
        employees.forEach(
                (x)-> System.out.println(x)
        );
    }

    //优化方式4：java18 api
    @Test
    public void  test5(){
        employees.stream()
                .filter((x) -> x.getSalary()>5000)
                .forEach(
                        (x) -> System.out.println(x)
                );

        System.out.println("-------------------------------------");

        employees.stream()
                //.map((x)->x.getName())
                .map(Employee::getName)
                .limit(3)
                .forEach(
                        (x) -> System.out.println(x)
                );
    }

    List<Employee> filterEmp3(List<Employee> list,Predicate<Employee> fs){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if(fs.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }
}
