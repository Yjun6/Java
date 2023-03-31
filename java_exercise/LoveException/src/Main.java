/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    void love(String s) throws LoveException{
        if(!this.name.equals(s)){
            throw new LoveException("你爱错了人!");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Person person = new Person("邹及");
        try{
            person.love("邹雨洁");
        }catch(LoveException e){
            e.printStackTrace();
            System.out.println("拾起信心，再出发！");
        }finally {
            System.out.println("为了未来，拼搏，奋斗！");
        }
    }
}