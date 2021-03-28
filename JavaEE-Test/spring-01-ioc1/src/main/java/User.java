/**
 * @author ：ZXF
 * @program: JavaEE
 * @description:
 * @date ：2021-03-27 19:18
 */

public class User {
    private String name;

    public User(){
        System.out.println("new User");
    }

    public User(String name){
        this.name = name;
        System.out.println("User");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name" + name);
    }
}
