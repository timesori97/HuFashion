package fashion;
import java.util.Scanner;
import java.util.ArrayList;

public class ClothAdmin {
   private ClothDAO clothdao = new ClothDAO();
   
   
   ClothAdmin(){
      Scanner Scan = new Scanner(System.in);
      boolean TF = true;
      while(TF){
         System.out.println("1.의류 등록 2.의류 전체보기 3.의류 정보 삭제 4.의류 정보 수정");
         System.out.println("메뉴를 선택하세요: ");
         int selectMenu = Scan.nextInt();
         Scan.nextLine();
         
         switch(selectMenu) {
            case 1:
               add();
               break;
            case 2:
               allView();
               break;
            case 3:
               delete();
               break;
            case 4:
               update();
               break;
               
            default:
               TF = false;
               break;
         }
      }
   }
   
   private void delete() {
      Scanner Scan = new Scanner(System.in);
      System.out.println("옷 정보 삭제 기능입니다.");
      System.out.println("삭제를 원하는 브랜드 이름을 입력하세요: ");
      String deleteBrand = Scan.nextLine();
      
      clothdao.delete(deleteBrand);
      
         
      
   }

   private void allView() {
   
      ArrayList<ClothDTO> c = clothdao.selectAll();
      for(ClothDTO cc : c) {
         cc.prt();
      }
      
   }

   private void add() {
      Scanner Scan = new Scanner(System.in);
      //브랜드 추가
      // 브랜드의 이름과 옷 유형, 가격을 입력받음
      System.out.println("옷 정보 등록 기능입니다.");
      System.out.println("브랜드 이름을 입력하세요: ");
      String brandName = Scan.nextLine();
      System.out.println("옷 유형을 입력하세요: ");
      String clothType = Scan.nextLine();
      System.out.println("가격을 입력하세요: ");
      int price = Scan.nextInt();
      System.out.println("옷 정보 등록을 성공했습니다.");
      Scan.nextLine();
      
      ClothDTO cloth = new ClothDTO();
      
      cloth.setBrandName(brandName);
      cloth.setClothType(clothType);
      cloth.setPrice(price);
      clothdao.insert(cloth);
      
      
      
   }
   
   private void update() {
      Scanner Scan = new Scanner(System.in);
      
      System.out.println("옷 정보 수정 기능입니다. ");
      
      System.out.println("수정할 원하는 브랜드의 이름을 입력하세요:");
      String brandName = Scan.nextLine();
      
      System.out.println("수정할 옷 유형을 입력하세요: ");
      String updateType = Scan.nextLine();
      
      System.out.println("수정할 옷 가격을 입력하세요:");
      int updatePrice = Scan.nextInt();
      
      clothdao.update(brandName, updateType, updatePrice);
   }

}