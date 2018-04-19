/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:14 2018/4/12
 * @Modified By:
 */
public class MysqlUser implements User {
    @Override
    public void insert() {
        System.out.println("增加一个用户--Mysql");
    }

    @Override
    public User getUser(int id) {
        System.out.println("得到一个用户--Mysql");
        return null;
    }
}
