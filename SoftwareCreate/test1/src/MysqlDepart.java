/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:15 2018/4/12
 * @Modified By:
 */
public class MysqlDepart implements Department {
    @Override
    public void insert() {
        System.out.println("增加一个部门--Mysql");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("得到一个部门--Mysql");
        return null;
    }
}
