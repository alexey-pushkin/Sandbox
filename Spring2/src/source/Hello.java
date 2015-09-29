package source;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {

    private String s;

    private String who;

    public Hello(String str){
        s = str;
    }

    public void sayHi(){
        System.out.println(s + " " + getWho());
    }

    public static void main(String []args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"source/spring.xml"});//показываем Spring где лежит файл конфигурации
        Hello h = (Hello) ac.getBean("hello");//указываем id нашего bean-а
        h.sayHi();
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}