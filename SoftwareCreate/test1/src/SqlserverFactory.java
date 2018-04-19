/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:04 2018/4/12
 * @Modified By:
 */
public class SqlserverFactory implements Factory {
    @Override
    public User createUser() {
        return new SqlserverUser();
    }

    @Override
    public Department createDepartment() {
        return new SqlserverDepart();
    }

    @Override
    public Project createProject() {
        return new SqlserverProject();
    }

    private static SqlserverFactory instance=null;
    public static SqlserverFactory getInstance(){
        if(instance==null){
            instance=new SqlserverFactory();
            System.out.println("SqlserverFactory实例化成功！");
        }else{
            System.out.println("SqlserverFactory实例已经存在！");
        }
        return instance;
    }
    private SqlserverFactory(){}
}
