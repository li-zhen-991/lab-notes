import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ScoreMain {

    static class Student {
        String name;
        double score;
        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> stuList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=====成绩管理菜单=====");
            System.out.println("1.录入成绩");
            System.out.println("2.显示全部");
            System.out.println("3.按分数排序");
            System.out.println("4.退出");
            System.out.print("请输入选择：");

            try {
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.print("请输入学生姓名：");
                    String name = sc.next();
                    System.out.print("请输入学生分数：");
                    double score = sc.nextDouble();
                    Student s = new Student(name, score);
                    stuList.add(s);
                    System.out.println("录入成功！");
                } else if (choice == 2) {
                    if (stuList.isEmpty()) {
                        System.out.println("还没有学生数据！");
                    } else {
                        System.out.println("-----学生成绩列表-----");
                        for (Student stu : stuList) {
                            System.out.println("姓名：" + stu.name + "，分数：" + stu.score);
                        }
                    }
                } else if (choice == 3) {
                    Collections.sort(stuList, Comparator.comparingDouble(stu -> stu.score));
                    System.out.println("排序完成！");
                } else if (choice == 4) {
                    System.out.println("程序退出");
                    sc.close();
                    return;
                } else {
                    System.out.println("输入错误，请重新选择！");
                }
            } catch (Exception e) {
                System.out.println("输入非法！只能输入数字！");
                sc.next();
            }
        }
    }
}
