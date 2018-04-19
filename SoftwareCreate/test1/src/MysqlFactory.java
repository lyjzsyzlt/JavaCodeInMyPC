/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:13 2018/4/12
 * @Modified By:
 */
public class MysqlFactory implements Factory {
    @Override
    public User createUser() {
        return new MysqlUser();
    }

    @Override
    public Department createDepartment() {
        return new MysqlDepart();
    }

    @Override
    public Project createProject() {
        return new MysqlProject();
    }

    private static MysqlFactory instance=null;
    public static MysqlFactory getInstance(){
        if(instance==null){
            instance=new MysqlFactory();
            System.out.println("MysqlFactory实例化成功！");
        }else{
            System.out.println("MysqlFactory实例已经存在！");
        }
        return instance;
    }
    private MysqlFactory(){}
}
