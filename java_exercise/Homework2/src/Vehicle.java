/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-03
 * Time:16:00
 */
public class Vehicle {
    private double speed;//速度
    private int power;//功率
    //加速功能
    public void speedUp(int s){
        this.speed += s;
    }
    //减速功能
    public void speedDown(int s){
        speed -= s;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed(){
        return this.speed;
    }
    public void setPower(int power){
        this.power = power;
    }
    public int getPower(){
        return this.power;
    }
}
