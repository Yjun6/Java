/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class User {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setPower(128);
        vehicle.setSpeed(100);
        System.out.println("vehicle的功率是："+vehicle.getPower());
        System.out.println("vehicle的速度是："+vehicle.getSpeed());
        System.out.println("加速后：");
        vehicle.speedUp(25);
        System.out.println("速度是："+vehicle.getSpeed());
        System.out.println("减速后：");
        vehicle.speedDown(12);
        System.out.println("速度是："+vehicle.getSpeed());
    }
}