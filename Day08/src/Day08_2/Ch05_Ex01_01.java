package Day08_2;

import Day08_3.AAA;

class BBB extends AAA{
   public void set() {
      // private 멤버는 서브에서도 접근 불가능.
      // privateData = 10; 
//      defaultData = 100; 
      //deafault 멤버는 다른 패키지에서 접근 불가
      protectedData = 1000;
      publicData = 10000;
   }
}




public class Ch05_Ex01_01 {
   public static void main(String[] args) {
      AAA aaa = new AAA();
      
      System.out.println(aaa.toString());
      System.out.println(aaa.equals(null));
      
   }
   
}
