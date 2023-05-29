import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private static List<Employee> list;

    public EmployeeManager() {
        Employee e1 = new Employee(12,"张建洋","男",
                22,"C++开发", 12000.0,
                "18627611015","成都");

        Employee e2 = new Employee(24,"张洋","男",
                24,"Java开发", 18000.0,
                "17658600597", "杭州");

        list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
    }

    public static void menu(){
        System.out.println();
        System.out.println("***************欢迎来到员工管理系统*****************");
        System.out.println();
    }

    //打印集合
    public static void prit(){
        System.out.println("===================================================\n");
        System.out.println("编号\t名字\t性别\t年龄\t电话\t岗位\t工资\t地址");
        for (Employee e :list) {
            System.out.println(""+e.getId()+"\t"+e.getName()+"\t"+e.getSex()+"\t"+e.getAge()+"\t"+
                    e.getPhone()+"\t"+e.getPosition()+"\t"+e.getSalary()+"\t"+e.getAddress());
        }
        System.out.println("\n===================================================");
        System.out.println();
    }

    //添加人员
    public static void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入员工的编号：");
        int id = scanner.nextInt();
        System.out.print("请输入员工的名字：");
        String name = scanner.next();
        System.out.print("请输入员工的年龄：");
        int age = scanner.nextInt();
        System.out.print("请输入员工的性别：");
        String sex = scanner.next();
        System.out.print("请输入员工的岗位：");
        String position = scanner.next();
        System.out.print("请输入员工的电话:");
        String phone = scanner.next();
        System.out.print("请输入员工的地址:");
        String address = scanner.next();
        System.out.print("请输入员工的工资:");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id,name,sex,age,position,salary,phone,address);
        list.add(employee);
    }

    //根据编号删除
    public static void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要删除的员工编号：");
        int id = scanner.nextInt();
        for (int i=0;i<list.size();i++) {
            if(list.get(i).getId() == id){
                list.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("没有找到需要删除的员工编号");
    }

    //修改
    public static void revise(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要修改的员工编号：");
        int id = scanner.nextInt();
        boolean ret = true;
        int i=0;
        for (;i<list.size();i++) {
            if(list.get(i).getId() == id){
                //找到了
                ret = false;
                break;
            }
        }
        if(ret){
            System.out.println("没有该员工信息");
            return;
        }

        //开始修改
        System.out.print("请输入新的名字：");
        String name = scanner.next();
        System.out.print("请输入新的年龄：");
        int age = scanner.nextInt();
        System.out.print("请输入新的性别：");
        String sex = scanner.next();
        System.out.print("请输入新的岗位：");
        String position = scanner.next();
        System.out.print("请输入新的电话:");
        String phone = scanner.next();
        System.out.print("请输入新的地址:");
        String address = scanner.next();
        System.out.print("请输入新的工资:");
        double salary = scanner.nextDouble();

        //修改集合
        Employee employee = new Employee(id,name,sex,age,position,salary,phone,address);
        list.set(i,employee);
    }

    public static void main(String[] args) {
        new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        menu();

        while(true){
            System.out.println("\n****0.退出\t1.添加\t2.删除\t3.修改\t4.显示*****\n");
            System.out.print("请选择：");
            int choice  = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    //退出
                    System.exit(0);
                case 1:
                    //添加
                    add();
                    break;
                case 2:
                    //删除
                    remove();
                    break;
                case 3:
                    //修改
                    revise();
                    break;
                case 4:
                    //显示
                    prit();
                    break;
                default :
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }
}

