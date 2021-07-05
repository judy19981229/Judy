package text;

public class LeetCode860 {
    public static void main(String[] args) {

    }
    public boolean lemonadeChange(int[] bills) {
        int five=0;//五元的个数
        int ten=0;//十元的个数
        for(int bill:bills){//收到一张五元
            if(bill==5){
                five++;
            } else if(bill==10){//收到一张十元，找一张五元
                if(five<1){//没有五元可找
                    return false;
                }
                five--;
                ten++;
            } else{//收到一张二十元
                if(ten>0){//有十元优先找一张十元一张五元
                    if(five<1){return false;}
                    ten--;
                    five--;
                }else{//没十元找三张五元
                    if(five<3){return false;}
                    five-=3;
                }
            }
        }
        return true;
    }
}
