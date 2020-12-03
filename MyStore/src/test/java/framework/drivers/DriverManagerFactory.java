package framework.drivers;

public class DriverManagerFactory {
	
	public static DriverManager getManager(String driverType) {
			if (driverType.equals("Firefox")) {
				return new FirefoxDriverManager();
			}
			if(driverType.equals("Chrome")) {
				return new ChromeDriverManager();
			}
			return null;
	}
}
