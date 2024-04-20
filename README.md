Here are the steps for creating each project type in Eclipse along with the required jar files and how to add them:

### Simple Java Project (for Collections and Multi-Threading):
1. **Create Project**:
   - Go to `File` -> `New` -> `Java Project`.
   - Enter a project name and click `Finish`.

2. **Write Code**:
   - Create Java classes with collection and multi-threading code.

3. **Required Jar Files**:
   - No additional jar files are required for basic collection and multi-threading code.

### Dynamic Web Project (JSP):
1. **Create Project**:
   - Go to `File` -> `New` -> `Dynamic Web Project`.
   - Enter a project name and click `Next`.
   - Choose the target runtime (e.g., Apache Tomcat) and click `Next`.
   - Configure the project settings and click `Finish`.

2. **Write Code**:
   - Create JSP files in the `WebContent` directory.

3. **Required Jar Files**:
   - You'll need the servlet-api.jar file.
   - To add it:
     - Right-click on the project -> `Build Path` -> `Configure Build Path`.
     - Click `Add External JARs...` and select the servlet-api.jar file.

### Spring Project:
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

These steps should help you set up each type of project in Eclipse with the necessary jar files. Let me know if you need more detailed instructions for any specific step!
