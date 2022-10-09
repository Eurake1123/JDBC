Java DateBase Connectivity
=

>**目的**：使用统一的一套Java代码操作所有的关系型数据库

>**本质**：一套操作所有关系型数据库的规则（接口）
>>* 接口由商家自行实现,提供数据库驱动jar包

>**使用步骤**：  
1.导入jar包  
2.注册驱动  
3.获取数据库连接对象 Connection  
4.定义sql   
5.执行SQL语句对象 Statement/PreparedStatement  
6.执行SQL，接受返回结果   
7.处理结果   
8.释放资源

### 各个对象

> * **DriverManager：驱动管理对象**
>   * **注册驱动**
>     * static void registerDriver(Driver driver)
>     * Class.forName("com.mysql.cj.jdbc.Driver")
>       * com.mysql.cj.jdbc.Driver中有静态代码块
>         ```aidl
>         static {
>            try {
>               DriverManager.registerDriver(new Driver());
>            } catch (SQLException var1) {
>               throw new RuntimeException("Can't register driver!");
>            }
>         }
>   * **获取数据库连接**
>     *  public static Connection getConnection(String url, String user, String password)
>       * url:指定链接路径    (jdbc:mysql://ip地址(域名):端口号/数据库名称) 
>       * user: 用户名   
>       * password：密码   

> * **Connection：数据库连接对象**
>   * **获取执行sql对象**
>       * Statement createStatement()
>       * PreparedStatement prepareStatement(String sql)
>   * **管理事务**  
>     * 开启事务
>     * 提交事务
>     * 回滚事务  

> * **Statement：执行SQL对象**   
>   * 执行静态SQL语句   
>     * boolean execute(String sql) 执行任意SQL语句 
>     * int executeUpdate(String sql) 执行DML(insert、update、delete),DDL语句
>       * 返回值：语句影响行数
>     * ResultSet executeQuery(String sql) 执行DQL语句    

> * **ResultSet：结果集对象**   
>   * boolean next() 游标从当前位置向下移动一行
>   * Xxx getXxx(参数) 获取当前行数据
>     * Xxx: 代表数据类型
>     * 参数: int 表示列的编号; String 表示列的名称

> * **PreparedStatement：执行SQL对象**
>   * 避免SQL注入问题
>     * SQL注入：拼接SQL时有特殊字符参与字符串拼接，造成安全问题
>   * 执行预编译SQL：参数使用占位符（？）
>     * setXxx(参数1，参数2)
>       * 参数1：？的位置编号，从1开始
>       * 参数2：？的值

    statement与preparedstatement比较:后者可以防止SQL注入且更高效  

数据库连接池
=

> **概念**：存放数据库连接的容器

> **使用**：  
>  系统初始化后，容器被创建，然后容器申请连接对象。用户访问数据库时，从容器中获取连接对象，用户访问完成后，将连接对象归还容器。

> **优点**：节约资源；用户访问高效

> **实现**:    
> DataSource接口由驱动程序供应商实现    
> 标准接口：DataSource java.sql包下
> * 获取：getConnection()
> * 归还：Connection.close(),将连接归还而非释放

### C3P0:数据库连接池技术

> **使用步骤**：
> 1. 导入jar包
     >   * c3p0-0.9.5.2.jar
>   * mchange-commons-java-0.2.12.jar
> 2. 定义配置文件
     >   * 名称：必须是 c3p0.properties 或者 c3p0-config.xml(自动加载)
>   * 路径：直接放在src目录下
> 3. 创建核心对象 数据库连接池对象 ComboPooledDataSource
> 4. 获取连接


### Druid：数据库连接池实现技术，由阿里巴巴提供

> **使用步骤**：
> 1. 导入jar包
     >   * druid-1.0.9.jar
> 2. 定义配置文件
>    * .properties 文件 (注意文件参数)
>    * 任意名称，任意目录（手动加载）
> 3. 加载配置文件
> 4. 获取数据库连接池对象 通过工厂类获取 DruidDataSourceFactory
> 5. 获取连接

# Spring JDBC
> Spring框架对JDBC的简单封装

> **使用步骤**：
> 1. 导入jar包
> 2. 创建JdbcTemplate对象
>    * 依赖于数据源DataSource
>    * JdbcTemplate template =new JdbcTemplate(dataSource);
> 3. 调用JdbcTemplate方法完成CRUD的操作
>    * update(): 执行DML语句。增删改
>    * queryForMap(): 将查询结果封装为map集合
>    * queryForList(): 将查询结果集封装为list集合
>    * query(): 将查询结果封装为JavaBean对象
>      * query的参数 RowBean
>        * 一般使用 BeanPropertyRowMapper实现类,完成数据到JavaBean的自动封装
>        * new BeanPropertyRowMapper<>(类.class)
>    * queryForObject(): 将查询结果封装为对象
>      * 一般用于聚合函数的查询




