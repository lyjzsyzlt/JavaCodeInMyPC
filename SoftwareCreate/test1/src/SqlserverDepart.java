/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:10 2018/4/12
 * @Modified By:
 */
public class SqlserverDepart implements Department {
    @Override
    public void insert() {
        System.out.println("插入一个部门");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("得到一个部门");
        return null;
    }
}
