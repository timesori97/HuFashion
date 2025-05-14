package fashion;

public class ClothDTO {
   private String BrandName;
   private String ClothType;
   private int Price;

	public String getBrandName() {
	return BrandName;
}


public void setBrandName(String brandName) {
	BrandName = brandName;
}


public String getClothType() {
	return ClothType;
}


public void setClothType(String clothType) {
	ClothType = clothType;
}


	public int getPrice() {
	return Price;
}


public void setPrice(int price) {
	Price = price;
}


	public void prt() {
		System.out.println("브랜드 이름 : "+this.BrandName);
		System.out.println("옷 타입 : " + this.ClothType);
		System.out.println("가격 :"+Price );
		
	}
	
}
