package util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    String workingDir = System.getProperty("user.dir");
    private final String propertyFilePath= workingDir+"/src/main/java/basePackage/GlobalProperty.properties";
    


    public ConfigFileReader(){

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public String getBrowser(){
        String browser =properties.getProperty("browser");
        if(browser!=null) {

            return browser;
        }
        else throw new RuntimeException("Browser not specified in the properties file");
    }



    public String getUrl(){
        String url = properties.getProperty("url");
        if(url!= null){
           
            return url;}
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }

    public String getPassword(){
        String password = properties.getProperty("password");
        if(password!= null){
           
            return password;}
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }
    
    public String getUserName(String uName){
    	 
        String username = properties.getProperty(uName);

        if(username!= null){
        //	 System.out.println("username=="+username);
            return username;}
        else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }
    
    public String gethomePageurl(){
   	 
        String homePageurl = properties.getProperty("homePageurl");

        if(homePageurl!= null){
        //	 System.out.println("username=="+username);
            return homePageurl;}
        else throw new RuntimeException("homePageurl not specified in the Configuration.properties file.");
    }
    
    public String geterrorMessage(){
      	 
        String loginErrorMessage = properties.getProperty("loginErrorMessage");

        if(loginErrorMessage!= null){
        //	 System.out.println("username=="+username);
            return loginErrorMessage;}
        else throw new RuntimeException("loginErrorMessage not specified in the Configuration.properties file.");
    }
    
    public String getlockedErrorMessage(){
     	 
        String lockedErrorMessage = properties.getProperty("lockedErrorMessage");

        if(lockedErrorMessage!= null){
        //	 System.out.println("username=="+username);
            return lockedErrorMessage;}
        else throw new RuntimeException("lockedErrorMessage not specified in the Configuration.properties file.");
    }
  
}