package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class EtcTest {
    @Test
    void isEqualTo() {
        assertThat("test1").isEqualTo("test1");
    }

    @Test
    void isEqualToObject_fail() {
        Dog dog1 = new Dog(7, "cookie");
        Dog dog2 = new Dog(7, "cookie");

        assertThat(dog1).isEqualTo(dog2);
    }

    @Test
    @DisplayName("객체 내용을 비교하고자 할때")
    void isEqualToObject_success() {
        Home home1 = new Home("house1");
        Home home2 = new Home("house1");
        Dog dog1 = new Dog(7, "cookie", home1);
        Dog dog2 = new Dog(7, "cookie", home2);

        // [참조] https://www.javadoc.io/static/org.assertj/assertj-core/3.18.1/deprecated-list.html
        // 객체내의 클래스형의 필드가 존재할경우 내용을 비교하지 않고 isEqualTo와 같이 비교하므로 비권장
//        assertThat(dog1).isEqualToComparingFieldByField(dog2);
        assertThat(dog1).usingRecursiveComparison().isEqualTo(dog2);
    }

    @Test
    void isGreaterThanOrEqualTo() {
        // 크다는 것은 사전순으로 뒤에 존재한다는 의미 예를 들어 a,b,c 인경우 b는 a보다 크다
        assertThat('b').isGreaterThanOrEqualTo('a');
    }

    @Test
    void FileTest() {
        File file = new File("C:\\workspace\\pleaseRead.txt");

        assertThat(file).isFile()
                .canRead()
                .canWrite();
    }

    class Dog {
        int age;
        String name;
        Home home;

        public Home getHome() {
            return home;
        }

        public void setHome(Home home) {
            this.home = home;
        }

        public Dog(int age, String name, Home home) {
            this.age = age;
            this.name = name;
            this.home = home;
        }

        public Dog(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Home {
        String name;

        public Home(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
