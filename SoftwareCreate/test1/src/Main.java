/**
 * @Author: YongjieLv
 * @Description:
 * @Date: Create in 19:18 2018/4/12
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Factory factory=SqlserverFactory.getInstance();
        User user1=factory.createUser();
        user1.insert();
        user1.getUser(1);
        Department department=factory.createDepartment();
        department.insert();
        department.getDepartment(1);
        Project project=factory.createProject();
        project.insert();
        project.getProject(1);

        Factory factory2=SqlserverFactory.getInstance();
    }
}
