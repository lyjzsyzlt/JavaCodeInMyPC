/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:11 2018/4/12
 * @Modified By:
 */
public class SqlserverProject implements Project {
    @Override
    public void insert() {
        System.out.println("增加一个项目");
    }

    @Override
    public Project getProject(int id) {
        System.out.println("得到一个项目");
        return null;
    }
}
