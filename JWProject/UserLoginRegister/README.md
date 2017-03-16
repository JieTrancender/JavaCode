common-dbutils.jar

#### QueryRunner

1. update方法

int update(String sql, Object... params) --->可执行增、删、改语句
int update(Connection, String sql, Object... params) -->需要调用者提供Connection，这说明笨方法不再管理Connection了,支持事务

2. query方法

T query(String sql, ResultSetHandler rsh, Object... params) --->可执行查询
它会先得到ResultSet，然后调用rsh的handle方法吧rs转换成需要的类型

T query(Connection conn, String sql, ResultSetHandler rsh, Object... params)

#### ResultSetHandler接口
1. BeanHandler(单行) 构造器需要一个Class类型的参数，用来把一行结果转换成指定类型的JavaBean对象

2. BeanListHandler(多行)
构造器也是需要一个Class类型的参数，用来把一行结果集转换成一个JavaBean，那么多行就是转换成List对象

3. MapHandler(单行)
把一行结果集转换成Map对象

3. MapListHandler(多行)
把一行记录转换成一个Map，多行就是多个Map，即List<Map>

4. ScalarHandler(单行单列)
通常用于select count(*) from user语句，结果集是单行单列的，他返回一个Object
