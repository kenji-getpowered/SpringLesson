package fr.mikaelkrok.springlesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.mikaelkrok.springlesson.SpringBean;

/**
 * 
 * @author Mikael KROK 
 * 
 */
public class SpringLesson 
{
   public static void main(String[] args) {
      ApplicationContext context = 
				new ClassPathXmlApplicationContext("springlesson-application-context.xml");

	  SpringBean obj = (SpringBean) context.getBean("springBean");
      System.out.println(obj.getMessage());
   }
}
