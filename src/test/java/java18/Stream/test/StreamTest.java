package java18.Stream.test;

import org.junit.Test;
import java18.Stream.test.dto.UserCourseDto;

import java.math.BigInteger;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * 流（Stream）到底是什么呢？
 * 是数据渠道，用于操作数据源所生成的元素序列
 * 集合讲的是数据，流讲的是计算
 *
 * 流不会改变源数据
 *
 * 创建流
 * 中间操作
 * 终止操作
 *
 * 流的构成
 * 当我们使用一个流的时候，通常包括三个基本步骤：
 * 获取一个数据源（source）→ 数据转换→执行操作获取想要的结果，每次转换原有 Stream 对象不改变，返回一个新的 Stream 对象（可以有多次转换），这就允许对其操作可以像链条一样排列，变成一个管道，如下图所示。
 *
 * 有多种方式生成 Stream Source：
 从 Collection 和数组
 Collection.java18()
 Collection.parallelStream()
 Arrays.java18(T array) or Stream.of()
 从 BufferedReader
 java.io.BufferedReader.lines()
 静态工厂
 java.util.java18.IntStream.range()
 java.nio.file.Files.walk()
 自己构建
 java.util.Spliterator
 其它
 Random.ints()
 BitSet.java18()
 Pattern.splitAsStream(java.lang.CharSequence)
 JarFile.java18()
 *
 *
 * 流的操作类型分为两种：
 Intermediate：一个流可以后面跟随零个或多个 intermediate 操作。其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用。这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
 Terminal：一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
 在对于一个 Stream 进行多次转换操作 (Intermediate 操作)，每次都对 Stream 的每个元素进行转换，而且是执行多次，这样时间复杂度就是 N（转换次数）个 for 循环里把所有操作都做掉的总和吗？其实不是这样的，转换操作都是 lazy 的，多个转换操作只会在 Terminal 操作的时候融合起来，一次循环完成。我们可以这样简单的理解，Stream 里有个操作函数的集合，每次转换操作就是把转换函数放入这个集合中，在 Terminal 操作的时候循环 Stream 对应的集合，然后对每个元素执行所有的函数。
 还有一种操作被称为 short-circuiting。用以指：
 对于一个 intermediate 操作，如果它接受的是一个无限大（infinite/unbounded）的 Stream，但返回一个有限的新 Stream。
 对于一个 terminal 操作，如果它接受的是一个无限大的 Stream，但能在有限的时间计算出结果。
 当操作一个无限大的 Stream，而又希望在有限时间内完成操作，则在管道内拥有一个 short-circuiting 操作是必要非充分条件。


 * @see Collectors
 * @see IntStream
 * @see LongStream
 * @see DoubleStream
 * @see Optional
 * @see Collector
 *
 */
public class StreamTest {

    private List<UserCourseDto> getSource(){
        List<UserCourseDto> source= Arrays.asList(new UserCourseDto(600169l,1005l,35l,26l,100001936l),
                new UserCourseDto(600165l,1006l,35l,27l,100001936l),
                new UserCourseDto(600177l,1007l,35l,28l,100001936l),
                new UserCourseDto(600178l,1008l,35l,29l,100001936l),
                new UserCourseDto(600176l,1009l,35l,30l,100001936l),
                new UserCourseDto(600175l,1010l,35l,31l,100001936l),
                new UserCourseDto(600169l,1005l,36l,41l,100001989l),
                new UserCourseDto(600168l,1011l,36l,47l,100001989l),
                new UserCourseDto(600165l,1006l,36l,42l,100001989l),
                new UserCourseDto(600168l,1011l,36l,47l,100001994l),
                new UserCourseDto(600169l,1005l,36l,41l,100001994l),
                new UserCourseDto(600171l,1012l,36l,48l,100001994l),
                new UserCourseDto(600175l,1010l,36l,46l,100001994l),
                new UserCourseDto(600176l,1009l,36l,45l,100001994l),
                new UserCourseDto(600177l,1007l,36l,43l,100001994l),
                new UserCourseDto(600165l,1006l,36l,42l,100001994l),
                new UserCourseDto(600178l,1008l,36l,44l,100001994l),
                new UserCourseDto(600182l,1013l,37l,64l,100001950l)
               );
        return source;
    }

    /**
     * 中间操作
     * Stream<T> filter(Predicate<? super T> predicate);
     * 返回所有符合predicate(断言型接口，返回boolean)条件的数据流
     * 原始Stream转换成一个新的Stream,这个新生成的Stream中的元素只保留符合条件。
     *
     * 常用于 筛选某些数据
     */
    @Test
    public void filterTest(){
        this.getSource().stream().filter(dto->dto.getClassId()>35).forEach(dto->{
            System.out.println(dto);
        });
        List<UserCourseDto> collect = this.getSource().stream().filter(dto -> dto.getClassId() > 35).collect(Collectors.toList());
    }


    /**
     * 中间操作
     * Function<? super T, ? extends R> mapper(函数型接口，入参为T，返回值为R)
     * 针对源数据，按照一定的规则进行提取元素，一般为数据源对象中拥有返回值得方法
     * ps:
     *  List<UserCourseDto>  即UserCourseDto该对象中 拥有返回值的方法
     *
     *  常用于 提取对象中某个属性，与distance连用 起到 返回值中不存在相同数据
     */
    //<R> Stream<R> map(Function<? super T, ? extends R> mapper);
    @Test
    public void mapTest(){
        this.getSource().stream().map(UserCourseDto::getUserId).forEach(id->System.out.println(id));
        List<Long> userIds = this.getSource().stream().map(UserCourseDto::getUserId).collect(Collectors.toList());
    }

    /**
     * 中间操作
     *ToIntFunction<? super T> mapper 入参为T，返回值类型为int
     * 针对源数据，按照一定的规则进行提取元素，一般为数据源对象中拥有返回值为int的方法,可以免除自动装箱/拆箱的额外消耗；
     * 原始Stream转换成一个新的Stream，这个新生成的Stream中的元素都是int类型。
     *
     * 常用于 提取对象中某个属性，与distance连用 起到 返回值中不存在相同数据（当返回值明确为int或Integer时  使用）
     */
    //IntStream mapToInt(ToIntFunction<? super T> mapper);
    @Test
    public void mapToTntTest(){
        this.getSource().stream().mapToInt(dto->{
            return Integer.parseInt(dto.getClassId()+"");
        }).forEach(id->{
            System.out.println(id);
        });
        OptionalInt max = this.getSource().stream().mapToInt(dto -> {
            return Integer.parseInt(dto.getClassId() + "");
        }).max();
        System.out.println("------------"+max.getAsInt());
        List<Integer> collect = this.getSource().stream().mapToInt(dto -> {
            return Integer.parseInt(dto.getClassId() + "");
        }).boxed().collect(Collectors.toList());
    }

    /**
     * 中间操作
     * ToLongFunction<? super T> mapper 入参为T，返回值类型为Long
     * 针对源数据，按照一定的规则进行提取元素，一般为数据源对象中拥有返回值为Long的方法,可以免除自动装箱/拆箱的额外消耗；
     * 原始Stream转换成一个新的Stream，这个新生成的Stream中的元素都是long类型。
     *
     * 常用于 提取对象中某个属性，与distance连用 起到 返回值中不存在相同数据（当返回值明确为long或Long时  使用）
     */
    //LongStream mapToLong(ToLongFunction<? super T> mapper);
    @Test
    public void mapToLongTest(){
        //与mapToInt 类似
        LongStream longStream = this.getSource().stream().mapToLong(UserCourseDto::getUserId);
    }

    /**
     * 中间操作
     * ToDoubleFunction<? super T> mapper mapper 入参为T，返回值类型为double
     * 针对源数据，按照一定的规则进行提取元素，一般为数据源对象中拥有返回值为double的方法,可以免除自动装箱/拆箱的额外消耗；
     * 原始Stream转换成一个新的Stream，这个新生成的Stream中的元素都是double类型。
     *
     * 常用于 提取对象中某个属性，与distance连用 起到 返回值中不存在相同数据（当返回值明确为double或Double时  使用）
     */
    //DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);
    @Test
    public void mapToDoubleTest(){
        //与mapToInt 类似
    }


    /**
     * 中间操作
     * flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字
     * 常用于 list<list<>>
     */
    //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
    @Test
    public void flatMapTest(){
        /*List<String> lsits = Arrays.asList("hello","world");
        List<String> collect = lsits.java18().map(str -> str.split("")).flatMap(str -> Arrays.java18(str)).collect(Collectors.toList());
        collect.forEach(str-> System.out.println(str));*/

        this.getSource().stream().flatMap(dto->Stream.of(dto.getUserId())).forEach(o-> System.out.println(o));
    }


    //IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);

    //LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);

    //DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);

    /**
     * 中间操作
     * 原始Stream转换成一个新的Stream，这个新生成的Stream中的元素将去除相同值的元素（如果是对象 则hashcode和equals相同）
     *
     * 常用于 去除相同的元素
     */
    //Stream<T> distinct();
    @Test
    public void distinctTest(){
        List<Long> collect = this.getSource().stream().map(UserCourseDto::getCompanyId).distinct().collect(Collectors.toList());
        this.getSource().stream().map(UserCourseDto::getCompanyId).distinct().forEach(companyId->{
            System.out.println(companyId);
        });
    }

    /**
     * 中间操作
     *原始Stream转换成一个新的Stream，这个新生成的Stream中的元素默认按升序排序
     * 注意 对象不能直接进行sorted 除非实现了Comparable类中的compareTo
     *
     * 常用于 对数字的排序
     */
    //Stream<T> sorted();
    @Test
    public void sortedTest(){
        this.getSource().stream().map(UserCourseDto::getUserId).sorted().forEach(userId-> System.out.println(userId));
        this.getSource().stream().map(UserCourseDto::getUserId).sorted().collect(Collectors.toList());
        this.getSource().stream().sorted().forEach(dto->System.out.println(dto));
    }

    /**
     *  中间操作
     * Comparator<? super T> comparator 排序规则
     * 原始Stream转换成一个新的Stream，这个新生成的Stream中的元素会按照comparator的排序规则进行排序
     *
     * 常用于 对集合的排序
     */
    //Stream<T> sorted(Comparator<? super T> comparator);
    @Test
    public void sortedComparatorTest(){
        this.getSource().stream().sorted((o1,o2)->{
            return (int)(o1.getClassId()-o2.getClassId());
        }).forEach(dto->System.out.println(dto));
    }

    /**
     *  中间操作
     * Stream.of("one", "two", "three", "four")
     .filter(e -> e.length() > 3)
     .peek(e -> System.out.println("Filtered value: " + e))
     .map(String::toUpperCase)
     .peek(e -> System.out.println("Mapped value: " + e))
     .collect(Collectors.toList());
     * Consumer<? super T> action  消费型
     * peek 对每个元素执行操作并返回一个新的 Stream
     * 该方法与forEach的作用相似， 只是peek是中间操作  而forEach是终止操作
     */
    //Stream<T> peek(Consumer<? super T> action);
    @Test
    public void peekTest(){
        /*Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());*/
        /*Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(str->System.out.println(str));*/
        List<String> str = new ArrayList<>();
        Stream.of("one", "two", "three", "four")
                //.filter(e -> e.length() > 3)
                .peek(e -> {
                    if (e.length()>2){
                        if(e.length()>3){
                            return;
                        }
                        str.add(e);
                    }
                })
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(str1->System.out.println(str1));
        System.out.println(str);
    }

    /**
     *  中间操作
     * 原始Stream转换成一个新的Stream，这个新生成的Stream中的元素只保留前maxSize位
     *
     * limit  不存在越界
     * 与skip 方法 可实现分页功能
     */
    //Stream<T> limit(long maxSize);
    @Test
    public void limitTest(){
        List<UserCourseDto> collect = this.getSource().stream().limit(20).collect(Collectors.toList());
        System.out.println(this.getSource().size());
        System.out.println(collect.size());
        this.getSource().stream().limit(this.getSource().size() + 1).forEach(dto->System.out.println(dto));
    }

    /**
     *中间操作
     * 原始Stream转换成一个新的Stream，这个新生成的Stream中的元素会跳过n位数据
     *
     * skip  不存在越界
     * 与limit 方法 可实现分页功能
     */
    //Stream<T> skip(long n);
    @Test
    public void skipTest(){
        this.getSource().stream().skip(20).collect(Collectors.toList());
        this.getSource().stream().skip(17).forEach(dto->System.out.println(dto));
    }

    /**
     *  终止操作
     * Consumer<? super T> action  消费型
     * 对源数据进行循环操作  没有返回值
     * 该方法与peek的作用相似， 只是peek是中间操作  而forEach是终止操作
     */
    //void forEach(Consumer<? super T> action);
    @Test
    public void forEachTest(){
        this.getSource().stream().forEach(dto->System.out.println(dto));
    }

    /**
     * 与forEach的区别
     * 其实两者完成的功能类似，主要区别在并行处理上，forEach是并行处理的，forEachOrder是按顺序处理的，显然前者速度更快。
     *
     * 在Stream中存在两种顺序：
     （1）encounter order：如果集合本身有序（比如：list），返回的结果就按集合的顺序；
     （2）thread order ：在并行情况下，集合被分成几部分分别在不同的线程中执行，有可能处于后面的元素先处理，这种线程顺序也称为时间顺序。
     以下代码中forEach打印的结果是乱序的，forEachOrdered是有顺序的。
     */
    //void forEachOrdered(Consumer<? super T> action);
    @Test
    public void forEachOrderedTest(){
        //this.getSource().java18().forEachOrdered(dto->System.out.println(dto));

        //Stream.of("AAA","BBB","CCC").parallel().forEach(s->System.out.println("Output:"+s));
        //Stream.of("AAA","BBB","CCC").parallel().forEachOrdered(s->System.out.println("Output:"+s));
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        list.stream().parallel().forEach(x -> System.out.print(x));
        System.out.println("");
        list.stream().parallel().forEachOrdered(x -> System.out.print(x));
    }

    /**
     * 将Stream转为数组
     */
    //Object[] toArray();
    @Test
    public void toArrayTest(){
        Object[] objects = this.getSource().stream().map(UserCourseDto::getClassId).toArray();
        System.out.println(objects);
    }

    /**
     * 将Stream转为数组  可以设定返回类型
     */
    //<A> A[] toArray(IntFunction<A[]> generator);
    @Test
    public void toArrayDtoTest(){
        UserCourseDto[] userCourseDtos = this.getSource().stream().toArray(UserCourseDto[]::new);
        System.out.println(userCourseDtos);
    }

    /**
     * 终止操作
     * reduce 方法相当于以下代码
     *      T result = identity;//赋予一个初始值
     *     for (T element : this java18) //循环遍历Stream或数据源
     *         result = accumulator.apply(result, element)// 针对每个元素 与初始值进行操作  并返回新的result
     *     return result;
     *
     * 聚合函数
     *
     * @return
     */
    //T reduce(T identity, BinaryOperator<T> accumulator);
    @Test
    public void reduceTest(){
        Long reduce = this.getSource().stream().map(UserCourseDto::getClassId).reduce(20L, (a, b) -> a + b);
        System.out.println(reduce);//741
        Long reduce1 = this.getSource().stream().map(UserCourseDto::getClassId).reduce(0L, (a, b) -> a + b);
        System.out.println(reduce1);//721  相差20
    }

    /**
     * 终止操作
     * boolean foundAny = false;
     *     T result = null;
     *     for (T element : this java18) {
     *         if (!foundAny) {
     *             foundAny = true;
     *             result = element;
     *         }
     *         else
     *             result = accumulator.apply(result, element);
     *     }
     *     return foundAny ? Optional.of(result) : Optional.empty();
     */
    //Optional<T> reduce(BinaryOperator<T> accumulator);
    @Test
    public void reduceTest1(){
        Optional<Long> reduce = this.getSource().stream().map(UserCourseDto::getClassId).reduce((a, b) -> a + b);
        Long aLong = reduce.get();
        System.out.println(aLong);//721  结果和 Long reduce1 = this.getSource().java18().map(UserCourseDto::getClassId).reduce(0L, (a, b) -> a + b);一致

    }

    /**
     * 终止操作
     *     U result = identity;
     *     for (T element : this java18)
     *         result = accumulator.apply(result, element)
     *     return result;
     *
     *     combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)
     */
    /*<U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);*/
    @Test
    public void reduceTest2(){
        Long reduce = this.getSource().stream().map(UserCourseDto::getClassId).reduce(20l, (a, b) -> a - b, (a, b) -> a - b);
        System.out.println(reduce);
    }

    /**
     * 终止操作
     *     R result = supplier.get();
     *     for (T element : this java18)
     *         accumulator.accept(result, element);
     *     return result;
     *     List<String> asList = stringStream.collect(ArrayList::new, ArrayList::add,
     *                                                ArrayList::addAll);
     *     String concat = stringStream.collect(StringBuilder::new, StringBuilder::append,
     *                                          StringBuilder::append)
     *                                 .toString();
     */
    /*<R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);*/
    @Test
    public void collectTest(){
        ArrayList<Object> collect = this.getSource().stream().map(UserCourseDto::getUserId).collect(ArrayList::new, ArrayList::add, ArrayList::retainAll);
        System.out.println(collect);
    }

    /**
     *终止操作
     *     List<String> asList = stringStream.collect(Collectors.toList());
     *
     *     Map<String, List<Person>> peopleByCity
     *         = personStream.collect(Collectors.groupingBy(Person::getCity));
     *
     *     Map<String, Map<String, List<Person>>> peopleByStateAndCity
     *         = personStream.collect(Collectors.groupingBy(Person::getState,
     *                                                      Collectors.groupingBy(Person::getCity)));
     */
    //<R, A> R collect(Collector<? super T, A, R> collector);
    @Test
    public void collectTest1(){
        //详见collectorsTest
    }


    /**
     * 终止操作
     * Comparator<? super T> comparator 比较
     *获取最小的值 通过comparator比较来获取
     */
    //Optional<T> min(Comparator<? super T> comparator);
    @Test
    public void minTest(){
        Optional<Long> min = this.getSource().stream().map(UserCourseDto::getClassId).min((a, b) -> a.compareTo(b));
        System.out.println(min.get());
        Optional<Long> min1 = this.getSource().stream().map(UserCourseDto::getClassId).min(Comparator.naturalOrder());
        System.out.println(min1.get());
        Optional<Long> min2 = this.getSource().stream().map(UserCourseDto::getClassId).min(Long::compareTo);
        System.out.println(min2.get());

        Optional<UserCourseDto> min3 = this.getSource().stream().min((a, b) -> a.getClassId().compareTo(b.getClassId()));
        System.out.println(min3.get());

    }


    /**
     * 终止操作
     *Comparator<? super T> comparator 比较
     *获取最大的值 通过comparator比较来获取
     *
     * @see StreamTest#minTest()
     */
    //Optional<T> max(Comparator<? super T> comparator);
    @Test
    public void maxTest(){
    }

    /**
     *终止操作
     * 获取总数
     */
    //long count();
    @Test
    public void countTest(){
        long count = this.getSource().stream().count();
        System.out.println(count);
        int size = this.getSource().size();
        System.out.println(size);
    }

    /**
     * 终止操作
     * Predicate<? super T> predicate
     * Stream中只要有一个满足条件 则最终返回true
     */
    //boolean anyMatch(Predicate<? super T> predicate);
    @Test
    public void anyMatchTest(){
        boolean b = this.getSource().stream().anyMatch(dto -> dto.getClassId() > 20);
        boolean b1 = this.getSource().stream().anyMatch(dto -> dto.getClassId() > 30);
        boolean b2 = this.getSource().stream().anyMatch(dto -> dto.getClassId() > 40);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
    }

    /**
     * 终止操作
     * Predicate<? super T> predicate
     * Stream中要全部满足条件 则最终返回true
     */
    //boolean allMatch(Predicate<? super T> predicate);
    @Test
    public void allMatchTest(){
        boolean b = this.getSource().stream().allMatch(dto -> dto.getClassId() > 20);
        boolean b1 = this.getSource().stream().allMatch(dto -> dto.getClassId() > 30);
        boolean b2 = this.getSource().stream().allMatch(dto -> dto.getClassId() > 40);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
    }

    /**
     * 终止操作
     * Predicate<? super T> predicate
     * Stream中要全部不满足条件 则最终返回true  与allMatch  相反
     */
    //boolean noneMatch(Predicate<? super T> predicate);
    @Test
    public void noneMatchTest(){
        boolean b = this.getSource().stream().noneMatch(dto -> dto.getClassId() > 20);
        boolean b1 = this.getSource().stream().noneMatch(dto -> dto.getClassId() > 30);
        boolean b2 = this.getSource().stream().noneMatch(dto -> dto.getClassId() > 40);
        boolean b3 = this.getSource().stream().noneMatch(dto -> dto.getClassId() > 100);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

    /**
     * 终止操作
     * 获取stream中的第一个元素
     */
    //Optional<T> findFirst();
    @Test
    public void findFirstTest(){
        Optional<UserCourseDto> first = this.getSource().stream().findFirst();
        System.out.println(first.get());
        Optional<Long> first1 = this.getSource().stream().map(UserCourseDto::getUserId).findFirst();
        System.out.println(first1.get());

        Consumer<Object> runnable = System.out::println;
        runnable.accept("以下的测试不是并行流");
        for (int i =0 ;i<10;i++){
            Optional<Long> any = this.getSource().stream().map(UserCourseDto::getClassId).findFirst();
            System.out.println(any.get());
        }
        runnable.accept("以下的测试是并行流");
        for (int i =0 ;i<10;i++){
            Optional<Long> any = this.getSource().stream().map(UserCourseDto::getClassId).parallel().findFirst();
            System.out.println(any.get());
        }
    }

    /**
     * 终止操作
     * 获取stream中的第一个元素
     * 当不是并行流的时候  和findFirst一样
     * 当是并行流的时候  findFirst还是获取一直获取第一个
     *                   而findAny则会随机获取
     */
    //Optional<T> findAny();
    @Test
    public void findAnyTest(){
        //错误示例
        //当第一次循环的时候 执行longStream.findAny()的时候  Stream流就已经结束了 ，所以当第二次执行的时候 流已经不存在了
        /*Stream<Long> longStream = this.getSource().java18().map(UserCourseDto::getClassId);
        for (int i =0 ;i<10;i++){
            Optional<Long> any = longStream.findAny();
            System.out.println(any.get());
        }*/
        Consumer<Object> runnable = System.out::println;
        runnable.accept("以下的测试不是并行流");
        for (int i =0 ;i<10;i++){
            Optional<Long> any = this.getSource().stream().map(UserCourseDto::getClassId).findAny();
            System.out.println(any.get());
        }
        runnable.accept("以下的测试是并行流");
        for (int i =0 ;i<10;i++){
            Optional<Long> any = this.getSource().stream().map(UserCourseDto::getClassId).parallel().findAny();
            System.out.println(any.get());
        }
    }

    /**
     * 创建流
     * 与java.util.java18.Stream.Builder 中的方法一起使用
     *//*
    public static<T> Stream.Builder<T> builder() {
        return new Streams.StreamBuilderImpl<>();
    }*/
    @Test
    public void builderTest(){
        Stream<Object> build = Stream.builder().add("abc").add("fsdfsd").add(123123).build();
        List<Object> collect = build.collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 创建流
     * 创建一个空的流
     */
    /*public static<T> Stream<T> empty() {
        return StreamSupport.java18(Spliterators.<T>emptySpliterator(), false);
    }*/
    @Test
    public void emptyTest(){
        List<Object> collect = Stream.empty().collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 创建流
     * 创建一个有数据的流 参数只有1个
     * 当不传入参数时 相当于empty()
     */
    /*public static<T> Stream<T> of(T t) {
        return StreamSupport.java18(new Streams.StreamBuilderImpl<>(t), false);
    }*/
    @Test
    public void ofTest(){
        Stream.of().forEach(str->System.out.println(str));
        List<Object> collect = Stream.of().collect(Collectors.toList());
        List<Object> collect1 = Stream.of("ABC").collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect1);
    }

    /**
     * 创建流
     * 创建一个有数据的流 参数可以是多个
     * 当不传入参数时 相当于empty()
     */
   /* public static<T> Stream<T> of(T... values) {
        return Arrays.java18(values);
    }*/
    @Test
    public void ofTest1(){
        /*String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
        System.out.println(property);*/
        Stream.of().forEach(str->System.out.println(str));
        List<Object> collect = Stream.of().collect(Collectors.toList());
        List<Object> collect1 = Stream.of("ABC",12312).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect1);
    }


    /**
     * 创建一个无限流
     * final T seed 种子 即初始值
     *final UnaryOperator<T> f  一元方程  用来对初始值做何种运算操作
     * 最好和short-circuiting 一起使用
     * 即：anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
     */
    @Test
    public void iterateTest(){
        Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.TEN)).limit(10);
        //Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN));
        BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
        System.out.println(Arrays.toString(bigIntArr));
    }

    /*
    public static<T> Stream<T> generate(Supplier<T> s) {
        Objects.requireNonNull(s);
        return StreamSupport.java18(
                new StreamSpliterators.InfiniteSupplyingSpliterator.OfRef<>(Long.MAX_VALUE, s), false);
    }

    */
    /**
     * 创建一个无限流
     * Supplier<T> s 这个无限流生成规则
     * 最好和short-circuiting 一起使用
     * 即：anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
     */
    @Test
    public void generateTest(){
        Stream<String> stream = Stream.generate(() -> "test").limit(10);
        String[] strArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));
    }
    /**
     * Creates a lazily concatenated java18 whose elements are all the
     * elements of the first java18 followed by all the elements of the
     * second java18.  The resulting java18 is ordered if both
     * of the input streams are ordered, and parallel if either of the input
     * streams is parallel.  When the resulting java18 is closed, the close
     * handlers for both input streams are invoked.
     *
     * @implNote
     * Use caution when constructing streams from repeated concatenation.
     * Accessing an element of a deeply concatenated java18 can result in deep
     * call chains, or even {@code StackOverflowException}.
     *
     * @param <T> The type of java18 elements
     * @param a the first java18
     * @param b the second java18
     * @return the concatenation of the two input streams
     *//*
    public static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);

        @SuppressWarnings("unchecked")
        Spliterator<T> split = new Streams.ConcatSpliterator.OfRef<>(
                (Spliterator<T>) a.spliterator(), (Spliterator<T>) b.spliterator());
        Stream<T> java18 = StreamSupport.java18(split, a.isParallel() || b.isParallel());
        return java18.onClose(Streams.composedClose(a, b));
    }

    */
    /**
     * 该接口中的方法和Stream类中的builder()方法一起使用 最后返回一个Stream
     */
    /*
    public interface Builder<T> extends Consumer<T> {

        *//**
         * Adds an element to the java18 being built.
         *
         * @throws IllegalStateException if the builder has already transitioned to
         * the built state
         *//*
        @Override
        void accept(T t);

        */

        /**
         *
         * 和 Stream.Builder<T> builder() 一起使用  添加元素
         */
        /*default Stream.Builder<T> add(T t) {
            accept(t);
            return this;
        }*/

        /*
        Stream<T> build();
    }*/

    @Test
    public void stremtest(){
        //this.getSource().java18().collect(Collectors.groupingBy(UserCourseDto::getClassId));

    }
}
