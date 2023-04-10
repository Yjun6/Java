package coa;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:16:19
 */
public class Dog {
    DogState state;
    void show(){
        state.showState();
    }

    public void setState(DogState state) {
        this.state = state;
    }
}
