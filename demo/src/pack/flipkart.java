package pack;



public class flipkart {
 
	public static void main(String[] args) {
		reuasablefunction ru = new reuasablefunction();
		ru.openbrowser();
		ru.enterUrL("http://flipkart.com");
		String title = ru.getTitle();
		System.out.println("title "+title);
		ru.login("au25ankurv@gmail.com", "Ankit#25");
		String getext = ru.Getext("//span[@class='_2cyQi_']");
		System.out.println(getext);
		
		ru.logout("(//a[@class='_2ZZi8V'])[2]");
		ru.click("//button[@class='_2AkmmA _29YdH8']");
		//System.out.println(ru.Getext("//input[@class='_2zrpKA']"));
		//ru.closebrowser();
	}

	}


