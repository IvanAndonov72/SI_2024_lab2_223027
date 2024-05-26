import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null){  //A
            throw new RuntimeException("allItems list can't be null!");  //B
        }

        float sum = 0; //C

        for (int i = 0; i < allItems.size(); i++){  //D1 D2 D3
            Item item = allItems.get(i);  //E
            if (item.getName() == null || item.getName().length() == 0){  //F
                item.setName("unknown");  //G
            }
            if (item.getBarcode() != null){  //H
                String allowed = "0123456789";  //I
                char chars[] = item.getBarcode().toCharArray();  //J
                for (int j = 0; j < item.getBarcode().length(); j++){  //K1 K2 K3
                    char c = item.getBarcode().charAt(j);  //L
                    if (allowed.indexOf(c) == -1){   //M
                        throw new RuntimeException("Invalid character in item barcode!");  //N
                    }
                }  //O
                if (item.getDiscount() > 0){  //P
                    sum += item.getPrice()*item.getDiscount();  //Q
                }
                else {
                    sum += item.getPrice();  //R
                }
            }
            else {
                throw new RuntimeException("No barcode!");  //S
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){  //T
                sum -= 30;  //U
               // throw new RuntimeException("Condition reached!");
            }
        } //V
        if (sum <= payment){  //W
            return true; //X
        }
        else {
            return false;  //Y
        }
    }  //Z
}