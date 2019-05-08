public class Exam {

    public static void main(String[] args) {
        Pikachu pika = new Pikachu("Pika");
        Pikachu pikachu = new Pikachu();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();

        System.out.printf("%s\n%s\n%s\n%s\n%s\n",
                pika, pikachu, charmander, squirtle, jigglypuff);

        pika.iChooseYou();
        pikachu.staticAttack();
        pika.comeBack();

        pikachu.iChooseYou();
        pikachu.staticAttack();
        pikachu.comeBack();

        charmander.iChooseYou();
        charmander.blazeAttack();
        charmander.comeBack();

        squirtle.iChooseYou();
        squirtle.torrentAttack();
        squirtle.comeBack();

        jigglypuff.iChooseYou();
        jigglypuff.singJigglypuff();
        jigglypuff.comeBack();
    }
}


class Pokemon {

    private String nickName, type;
    private int HP,CP;
    private double height, weight;

    public Pokemon(String nickName, String type, int HP, int CP, double height, double weight) {
        setNickName(nickName);
        setType(type);
        setHP(HP);
        setCP(CP);
        setHeight(height);
        setWeight(weight);
    }

    // All setters and getters
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setHP(int HP) {
        if (HP < 1 || 100 < HP)
            throw new IllegalArgumentException(" HP must be 1-100!");
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void setCP(int CP) {
        if (CP < 1 || 100 < CP)
            throw new IllegalArgumentException(" HP must be 1-100!");
        this.CP = CP;
    }

    public int getCP() {
        return CP;
    }

    public void setHeight(double height) {
        if (height < 0.3 || 0.9 < height)
            throw new IllegalArgumentException(" height must be 0.3-0.9!");
        this.height = height;
    }

    public double getHeight() { return height; }

    public void setWeight(double weight) {
        if (weight < 4 || 10 < weight)
            throw new IllegalArgumentException(" weight must be 4.0-10.0!");
        this.weight = weight;
    }

    public double getWeight() { return weight; }

    public void comeBack() { System.out.println(" On my way...\n"); }

    public void iChooseYou() { System.out.printf(" Ahhh I'm a super pokemon!\n"); }

    @Override
    public String toString() {
        return String.format(" %s%n NickName: %s%n Type: %s%n HP: %d%n CP: %d%n Height: %.1f%n Weight: %.1f%n",
                getClass(), getNickName(), getType(), getHP(), getCP(), getHeight(), getWeight());
    }
}


class Pikachu extends Pokemon {

    public Pikachu(String nickname) {
        super(nickname, "Electric", 35, 42,0.4,6);
    }

    public Pikachu() {
        this("LittlePikachu");
    }

    @Override
    public void iChooseYou() {
        System.out.printf(" Pickachu pika pika %s\n",
                super.getNickName());
    }

    @Override
    public void comeBack() {
        System.out.printf(" I am the great %s and no pokeball shall contain me!\n\n",
                super.getNickName());
    }

    public void staticAttack() { System.out.printf(" get static!\n"); }
}


class Charmander extends Pokemon {

    public Charmander() {
        super("LittleCharmander", "Fire", 39, 45, 0.6, 8.5);
    }

    public void blazeAttack() {
        System.out.printf(" Blaze attack! Now u will get burned.\n");
    }
}


class Squirtle extends Pokemon {

    public Squirtle() {
        super("LittleSquirtle", "Water", 35, 42,0.4,6);
    }

    public void torrentAttack() { System.out.printf(" take this water torrent!\n"); }
}


class Jigglypuff extends Pokemon {

    public Jigglypuff() {
        super("LittleBall", "Normal", 97, 13,0.5,5.5);
    }

    @Override
    public void iChooseYou() { System.out.printf(" Ladies and gentlemen I'd like to dedicate a song.\n\n"); }

    @Override
    public void comeBack() {
        System.out.println(" My gosh, all are sleeping again!");
    }

    public void singJigglypuff() {
        for (int j = 1; j < 13; j++) {
            String day = null;
            switch (j) {
                case 12: day = "twelfth"; break;
                case 11: day = "eleventh"; break;
                case 10: day = "tenth"; break;
                case 9: day = "ninth"; break;
                case 8: day = "eighth"; break;
                case 7: day = "seventh"; break;
                case 6: day = "sixth"; break;
                case 5: day = "fifth"; break;
                case 4: day = "fourth"; break;
                case 3: day = "third"; break;
                case 2: day = "second"; break;
                case 1: day = "first";
            }
            System.out.printf(" On the %s day of Christmas%n My true love gave to me:\n", day);
            switch (j) {
                case 12: System.out.printf(" Twelve drummers drumming\n");
                case 11: System.out.printf(" Eleven pipers piping%n");
                case 10: System.out.printf(" Ten lords a-leaping%n");
                case 9: System.out.printf(" Nine ladies dancing%n");
                case 8: System.out.printf(" Eight maids a-milking%n");
                case 7: System.out.printf(" Seven swans a-swimming%n");
                case 6: System.out.printf(" Six geese a-laying%n");
                case 5: System.out.printf(" Five golden rings%n");
                case 4: System.out.printf(" Four calling birds%n");
                case 3: System.out.printf(" Three french hens%n");
                case 2: System.out.printf(" Two turtle doves and%n");
                case 1: System.out.printf(" A partridge in a pear tree.%n");
            }
            System.out.println();
        }
    }
}
