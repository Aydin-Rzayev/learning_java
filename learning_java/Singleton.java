
class Dog{
    private static Dog dogInstance;
    private Dog(){
        System.out.println("Dog sinifi Singleton patternle hazirlanib");
    }

    public static Dog getInstance(){
        if(dogInstance == null){
            dogInstance = new Dog();
        }
        return dogInstance;
    }
    public static void Bark(){
        System.out.println("Hav Hav");
    }
}

class main{ // todo class adı PascalCase olmalıdır. Naming convention ilə tanış olun
    public static void main(String[] args){
        Dog.getInstance().Bark();
    }
}