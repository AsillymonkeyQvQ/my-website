# Using Apache Commons CSV

平时工作中会经常接触到[CSV](https://zh.wikipedia.org/wiki/%E9%80%97%E5%8F%B7%E5%88%86%E9%9A%94%E5%80%BC)文件，如何优雅地使用JAVA语言实现对CSV文件的处理[Apache Commons CSV](https://commons.apache.org/proper/commons-csv/)为我们提供了一种解决方案。

Commons CSV可以用来读写多种不同格式的逗号分隔值（Comma-Separated Values，**CSV**）文件。

## Maven仓库

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>1.8</version>
</dependency>
```

## 类

### [CSVFormat](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html)

**指定CSV文件的格式**

`CSVFormat`对象的构造需要指定以下属性。

| Attribute Name            | Attribute Type    | CSVFormat.DEFAULT |
| ------------------------- | ----------------- | ----------------- |
| delimiter                 | char              | `,`               |
| quoteCharacter            | Character         | `"`               |
| quoteMode                 | QuoteMode（枚举） | null              |
| commentMarker             | Character         | null              |
| escapeCharacter           | Character         | null              |
| ignoreSurroundingSpaces   | boolean           | `false`           |
| allowMissingColumnNames   | boolean           | `false`           |
| ignoreEmptyLines          | boolean           | `true`            |
| recordSeparator           | String            | `\r\n`            |
| nullString                | String            | null              |
| headerComments            | String[]          | null              |
| header                    | String[] header   | null              |
| skipHeaderRecord          | boolean           | `false`           |
| ignoreHeaderCase          | boolean           | `false`           |
| trailingDelimiter         | trailingDelimiter | `false`           |
| trim                      | boolean           | `false`           |
| autoFlush                 | autoFlush         | `false`           |
| allowDuplicateHeaderNames | boolean           | `true`            |

但私有的构造器意味着你并不能够通过`new`来创建它的对象，它提供了以下预定义的格式，你可以在预定义格式的基础上使用`with`方法对其进行扩展。

- [`DEFAULT`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#DEFAULT)
- [`EXCEL`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#EXCEL)
- [`INFORMIX_UNLOAD`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#INFORMIX_UNLOAD)
- [`INFORMIX_UNLOAD_CSV`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#INFORMIX_UNLOAD_CSV)
- [`MYSQL`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#MYSQL)
- [`RFC4180`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#RFC4180)
- [`ORACLE`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#ORACLE)
- [`POSTGRESQL_CSV`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#POSTGRESQL_CSV)
- [`POSTGRESQL_TEXT`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#POSTGRESQL_TEXT)
- [`TDF`](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html#TDF)

```java
CSVFormat.EXCEL.withNullString("N/A").withIgnoreSurroundingSpaces(true);
```

通过使用`withHeader(String...)`方法你还可以为记录定义列名，然后通过`CSVRecord`的`get(String)`方法来获取列值。这将使你的代码不再惧怕CSV文件中列顺序的改变。

```java
CSVFormat.EXCEL.withHeader("Col1", "Col2", "Col3");
String value = record.get("Col1");
```

### [CSVParser](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVParser.html)

**根据指定的格式解析CSV文件**

`CSVParser`提供了流畅的静态工厂方法用以从不同的源来获取它的对象。

* parse(File file, Charset charset, CSVFormat format)
* parse(Path path, Charset charset, CSVFormat format)
* parse(InputStream inputStream, Charset charset, CSVFormat format)
* parse(Reader reader, CSVFormat format)
* parse(String string, CSVFormat format)
* parse(URL url, Charset charset, CSVFormat format)

`CSVParser`使用迭代器模式实现了`Iterable<CSVRecord>`接口。这意味着你可以使用for-each语法去对它进行遍历操作来获取数据。

```java
File csvData = new File("/path/to/csv");
CSVParser parser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSVFormat.RFC4180);
for (CSVRecord csvRecord : parser) {
    ...
}
```

同时它还支持使用`getRecords()`将数据读入一个`CSVRecord`的List。

```java
Reader in = new StringReader("a;b\nc;d");
CSVParser parser = new CSVParser(in, CSVFormat.EXCEL);
List<CSVRecord> list = parser.getRecords();
```

但此时你必须要注意以下两点：

1. 读入List数据的个数取决于`CSVParser`对象当前游标的位置。如果你已经使用`CSVParser`对象解析了一部分数据，那么这部分数据将不会被读入到List中。
2. 由于是将数据一股脑儿地读入内存之中，数据量过大的话可能会导致系统资源占用过多甚至内存溢出。

### [CSVRecord](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVRecord.html)

**从CSV文件中解析过后的一条CSV记录**

包访问权限的构造器表明它期望你使用`CSVParser`来获取它的对象。

`CSVRecord`使用迭代器模式实现了`Iterable<String>`接口。这使得你可以很简单地遍历一条CSV记录中的值。

```java
for (String value : record) {
    ...
}
```

你还可以通过指定索引，列名等方式来访问特定列的值。

```java
String value = record.get(6);
String value = record.get("Col1");
```

它还提供了`getRecordNumber()`方法来很方便地获取当前对象记录是所解析的CSV文件中的第几条记录。

### [CSVPrinter](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVPrinter.html)

**使用CSV格式打印值**

通过调用`print(Object)`方法将值添加到输出，调用`println()`方法来结束一条记录。

通过调用`printRecord(Object...)`或`printRecord(Iterable)`方法来一次性添加一整条记录到输出。

通过调用`printRecords(Object...)`或`printRecords(Iterable)`或`printRecords(ResultSet)`方法来一次性添加多条记录到输出。

```java
 try (CSVPrinter printer = new CSVPrinter(new FileWriter("csv.txt"), CSVFormat.EXCEL)) {
     printer.printRecord("id", "userName", "firstName", "lastName", "birthday");
     printer.printRecord(1, "john73", "John", "Doe", LocalDate.of(1973, 9, 15));
     printer.println();
     printer.printRecord(2, "mary", "Mary", "Meyer", LocalDate.of(1985, 3, 29));
 } catch (IOException ex) {
     ex.printStackTrace();
 }
```

输出结果：

```txt
 id,userName,firstName,lastName,birthday
 1,john73,John,Doe,1973-09-15

 2,mary,Mary,Meyer,1985-03-29
```

## Example

*filename.csv*

```csv
"1","john73","John","Doe","1973-09-15"
2, N/A, Mary, Meyer, 1985-03-29
```

*User.java*

```java
public class User {

    private String id;

    private String userName;

    private String firstName;

    private String lastName;

    private String birthday;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

}
```

*Main.java*

```java
public class Main {

    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getClassLoader().getResourceAsStream("filename.csv");
        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator("\n")
                                            .withNullString("N/A")
                                            .withIgnoreSurroundingSpaces()
                                            .withHeader("id", "userName", "firstName", "lastName", "birthday");
        CSVParser parser = CSVParser.parse(in, StandardCharsets.UTF_8, format);

        List<String> headerNames = parser.getHeaderNames();
        List<User> list = new ArrayList<>();
        Class<User> clazz = User.class;
        for (CSVRecord record : parser) {
            User user = new User();
            for (String headerName : headerNames) {
                String value = record.get(headerName);
                Field field = clazz.getDeclaredField(headerName);
                field.setAccessible(true);
                field.set(user, value);
            }
            list.add(user);
        }

        list.stream().forEach(System.out::println);
    }

}
```

Output:

```
User{id='1', userName='john73', firstName='John', lastName='Doe', birthday='1973-09-15'}
User{id='2', userName='null', firstName='Mary', lastName='Meyer', birthday='1985-03-29'}
```
