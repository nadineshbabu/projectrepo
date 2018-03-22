package pack;

public class driverfile {

	public static void main(String[] args) {

		reuasablefunction    RB = new reuasablefunction();
		
		RB.openbrowser();RB.EditSetvalue("", "");
		RB.openbrowser();RB.EditSetvalue("", "");
		RB.click("");
		String getext = RB.Getext("");
		
		String Expst ="";
		if(Expst.equals(getext)){
			System.out.println("Test case pass");
		}else{
			System.out.println("Test case fail");
		}
		
	}

}
