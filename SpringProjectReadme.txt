1. **Create Project &** **Required Files**:
   create the java project
   add spring jar files
   create the class
   create the xml file to provide the values
   create the test class

   in.sp.beans
      Structure.java
   in.sp.main
      Main.java

   '''
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   import in.sp.beans.Structure;
   class main
   psvm(Str[]){
   String loc = "/in/.../applicationContext.xml"
   ApplicationContext ac = new ClassPathXmlApplicationContext(loc);
   Structure s1 = [Structure]context.getBeans("stdId");
   s1.display()
   }
   '''
   
   in.sp.resources
      applicationContext.xml
   '''
   <?xml version="1.0" encoding="UTF-8"?>  
<beans  
    xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns:p="http://www.springframework.org/schema/p"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans  
               http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">  
  
<bean id="studentbean" class="com.javatpoint.Student">  
<property name="name" value=""></property>  
</bean>  
  
</beans>  
'''