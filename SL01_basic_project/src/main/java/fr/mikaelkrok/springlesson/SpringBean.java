package fr.mikaelkrok.springlesson;

/**
 * 
 * @author Mikael KROK
 */
public class SpringBean {

   private String message;

   public void setMessage(String message){
      this.message  = message;
   }

   public String getMessage(){
      return "Your Message : " + message;
   }
}
