package text;

public class LeetCode2 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l4=new ListNode(0);
        ListNode l3=new ListNode(0);
        ListNode l5=new ListNode(0);
        ListNode l6=new ListNode(0);
        ListNode l7=new ListNode(0);
        ListNode l8=new ListNode(0);
        ListNode l9=new ListNode(0);
        ListNode l10=new ListNode(0);
        ListNode l11=new ListNode(0);
        ListNode l12=new ListNode(0);
        ListNode l13=new ListNode(0);
        ListNode l14=new ListNode(0);
        ListNode l15=new ListNode(0);
        ListNode l16=new ListNode(0);
        ListNode l17=new ListNode(0);
        ListNode l18=new ListNode(0);
        ListNode l19=new ListNode(0);
        ListNode l20=new ListNode(0);
        ListNode l21=new ListNode(0);
        ListNode l22=new ListNode(0);
        ListNode l23=new ListNode(1);


        ListNode l2=new ListNode(5);

        l1.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        l8.next=l9;
        l9.next=l10;
        l10.next=l11;
        l11.next=l12;
        l12.next=l13;
        l13.next=l14;
        l14.next=l15;
        l15.next=l16;
        l16.next=l17;
        l17.next=l18;
        l18.next=l19;
        l19.next=l20;
        l20.next=l21;
        l21.next=l22;
        l22.next=l23;

        /*l4.next=l5;
        l5.next=l6;
        l6.next=l11;*/
        ListNode listNode=solution(l1,l4);
        System.out.print(listNode.val+" ");
        while(listNode.next!=null){
            listNode=listNode.next;
            System.out.print(listNode.val+" ");
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode=null,ll=null;
        int change=0;
        while(l1!=null || l2!=null){
            int num1=(l1!=null? l1.val : 0);
            int num2=(l2!=null? l2.val : 0);
            int num=num1+num2+change;
            if(listNode==null){
                listNode=ll=new ListNode(num%10);
            } else{
                ll.next=new ListNode(num%10);
                ll=ll.next;
            }
            change=num/10;
            if(l1!=null){ l1=l1.next;}
            if(l2!=null){ l2=l2.next;}
        }
        if(change>0){
            ll.next=new ListNode(change);
        }
        return listNode;
    }

    public static ListNode solution(ListNode l1,ListNode l2) {
        ListNode listNode=null;
        ListNode ll=null;
        int change=0;
        while(l1!=null || l2!=null){
            int n1=(l1!=null?l1.val:0);
            int n2=(l2!=null?l2.val:0);
            int num=n1+n2+change;
            if (listNode==null){
                listNode=ll=new ListNode(num%10);
            } else{
                ll.next=new ListNode(num%10);
                ll=ll.next;
            }
            change=num/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(change>0){
            ll.next=new ListNode(change);
        }
        return listNode;

        /*ListNode listNode=null;
        ListNode ll=null;
        int carry=0;
        while(l1!=null || l2!=null){
            int n1=(l1!=null?l1.val:0);
            int n2=(l2!=null?l2.val:0);
            int sum=n1+n2+carry;
            if(listNode==null){
                listNode=ll=new ListNode(sum%10);
            } else{
                ll.next=new ListNode(sum%10);
                ll=ll.next;
            }
            carry=sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            ll.next=new ListNode(carry);
        }
        return listNode;*/
        /*ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;*/



        /*// 2 4 3 1
        // 5 6 4
        //1342+465
        //1807
        int count1 = 1;
        ListNode l11 = l1;
        ListNode l44 = l4;
        while (l11.next != null) {
            l11 = l11.next;
            count1++;
        }
        System.out.println("count1="+count1);
        int count2 = 1;
        while (l44.next != null) {
            l44 = l44.next;
            count2++;
        }
        System.out.println("count2="+count2);
        long num1 = 0;
        long num2 = 0;
        for (int i = 0; i < count1; i++) {
            num1 += (Math.pow(10, i) * l1.val);
            l1 = l1.next;
        }
        for (int i = 0; i < count2; i++) {
            num2 += (Math.pow(10, i) * l4.val);
            l4 = l4.next;
        }
        long num = num1 + num2; //1807
        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2);
        System.out.println("num=num1+num2=" + num);
        int max=1;
        *//*if (count1 > count2) {
            max = count1;
        } else {
            max = count2;
        }*//*
        long count=num;
        for(;count>0;count/=10){
            if(count/10!=0){
                max++;
            }
        }
        System.out.println("max=" + max); //4

        //1807输出为【7，0，8,1】
        // 1807%10=7
        // 1807/10=180 180%10=0
        // 1807/100=18 18%10=8
        // 1807/1000=1
        ListNode listNode;
        ListNode ll;
        int nums[] = new int[max];
        nums[0] = (int)(num % 10);
        listNode = ll = new ListNode(nums[0]);
        if (max > 1) {
            nums[max - 1] = (int) (num / Math.pow(10, max - 1));
            ll.next = new ListNode(nums[max - 1]);
            for (int i = 1; i < max - 1; i++) {
                nums[i] = (int) (num / Math.pow(10, i) % 10);
                ll.next = new ListNode(nums[i]);
                ll = ll.next;
            }
            nums[max - 1] = (int) (num / Math.pow(10, max - 1));
            ll.next = new ListNode(nums[max - 1]);
        }
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
        return listNode;*/
    }
}
