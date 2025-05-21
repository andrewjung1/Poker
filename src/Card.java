public class Card {
    int value;
    String suit;
    String cardName;

    public void drawPicture() {
        System.out.println("___________");
        System.out.println("| " + this.suit + "      |");
        System.out.println("|         |");
        System.out.println("|    " + this.cardName + "    |");
        System.out.println("|         |");
        System.out.println("|         |");
        System.out.println("-----------");
    }

    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
        if(2 <= this.value && this.value <= 10){
            this.cardName = String.valueOf(value);
        } else if(this.value == 1){
            this.cardName = "A";
        } else if(this.value == 11){
            this.cardName = "J";
        } else if(this.value == 12){
            this.cardName = "Q";
        } else if(this.value == 13){
            this.cardName = "K";
        }

    }

}
