package fr.mikaelkrok.springlesson;

public class SpringBean {

   private String message;

   public void setMessage(String message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}