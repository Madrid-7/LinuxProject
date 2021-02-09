import java.io.*;

public class Test {
    public static void main(String[] args) {
        int n = 0;

    }
}


class Person implements Serializable{

    //private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String sex;
    //transient修饰的变量,不能被序列化
    transient private int stuId;
    //static修饰的变量,不能被序列化
    private static int count = 99;
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public int getStuId() {
        return stuId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", stuId=" + stuId +
                ", count=" + count +
                '}';
    }
}

class TestDemo3 {
    public static void main(String[] args) throws Exception {
        serializePerson();
        Person person = deserializePerson();
        System.out.println(person.toString());
    }
    /**
     * 序列化
     */
    private static void serializePerson() throws IOException {
        Person person = new Person();
        person.setName("bit");
        person.setAge(10);
        person.setSex("男");
        person.setStuId(100);
        // ObjectOutputStream 对象输出流,将 person 对象存储到E盘的
        // person.txt 文件中,完成对 person 对象的序列化操作
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("person.txt")))) {
            oos.writeObject(person);
            System.out.println("person 对象序列化成功!");
        }
    }
    /**
     * 反序列化
     */
    private static Person deserializePerson() throws Exception {
        Person person;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person.txt")))) {
            person = (Person) ois.readObject();
        }
        System.out.println("person 对象反序列化成功!");
        return person;
    }
}

