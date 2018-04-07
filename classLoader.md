# Java ClassLoader
Java ClassLoader is one of the crucial but rarely used components of Java in Project Development. 
Personally I have never extended ClassLoader in any of my projects but the idea of having my own ClassLoader 
that can customize the Java Class Loading thrills me.

## What is Java ClassLoader?
We know that Java Program runs on Java Virtual Machine (JVM). When we compile a Java Class, 
it transforms it in the form of bytecode that is platform and machine independent compiled program and 
store it as a .class file. 
After that when we try to use a Class, Java ClassLoader loads that class into memory.

There are three types of built-in ClassLoader in Java:

## 1. Bootstrap Class Loader – 
It loads JDK internal classes, typically loads rt.jar and other core classes for example java.lang.* package classes

## 2. Extensions Class Loader – 
It loads classes from the JDK extensions directory, usually $JAVA_HOME/lib/ext directory.

## 3. System Class Loader – 
It loads classes from the current classpath that can be set 
while invoking a program using -cp or -classpath command line options.

# contd...
Java ClassLoader are hierarchical and whenever a request is raised to load a class, 
it delegates it to its parent and in this way uniqueness is maintained in the runtime environment. 
If the parent class loader doesn’t find the class then the class loader itself tries to load the class.

One more important point to note is that Classes loaded by a child class loader have visibility into classes loaded
by its parent class loaders. So classes loaded by System ClassLoader have visibility into classes 
loaded by Extensions and Bootstrap ClassLoader.

If there are sibling class loaders then they can’t access classes loaded by each other.

## Why write a Custom ClassLoader in Java?
Java default ClassLoader can load files from local file system that is good enough for most of the cases. 
But if you are expecting a class at the runtime or from FTP server or via third party web service at the time of 
loading the class then you have to extend the existing class loader. 
For example, AppletViewers load the classes from remote web server.

## How does Java ClassLoader Work?
When JVM requests for a class, it invokes loadClass function of the ClassLoader by passing the fully classified 
name of the Class.

loadClass function calls for findLoadedClass() method to check that the class has been already loaded or not. 
It’s required to avoid loading the class multiple times.

If the Class is not already loaded then it will delegate the request to parent ClassLoader to load the class.

If the parent ClassLoader is not finding the Class then it will invoke findClass() method to look for the 
classes in the file system.

## Java Custom ClassLoader
We will create our own ClassLoader by extending ClassLoader class and overriding loadClass(String name) method. 
If the name will start from com.LearningJava i.e our sample classes package then we will load it using our own class loader 
or else we will invoke the parent ClassLoader loadClass() method to load the class.


Source :
https://www.journaldev.com/349/java-classloader                                                                              
https://www.youtube.com/watch?v=S7whKuAvRBU                                                                                                                                                            

