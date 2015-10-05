package main;

public class Capital {
    private static Capital instance = null;

    private Capital(){}

    //фабричный метод
    public static Capital getInstance(){
        if(instance == null)
            instance = new Capital();
        return instance;
    }
}