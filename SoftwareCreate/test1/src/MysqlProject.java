/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:16 2018/4/12
 * @Modified By:
 */
public class MysqlProject implements Project {
    @Override
    public void insert() {
        System.out.println("增加一个项目--Mysql");
    }

    @Override
    public Project getProject(int id) {
        System.out.println("得到一个项目--Mysql");
        return null;
    }
}
