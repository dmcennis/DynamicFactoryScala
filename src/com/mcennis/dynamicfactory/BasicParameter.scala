package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._
import scala.collection.immutable.List
import java.lang.reflect.Field

class BasicParameter[T] (key:String, data : List[T],shortDescription:String="",description:String="", longDescription:String="", rule:SyntaxChecker[T])(implicit tag : TypeTag[T])extends ParameterInternal[T](key,data) {
//  rule = PropertyRestriction
  def prototype(key:String, data : List[T]):Parameter[T] = new BasicParameter[T](key,data,shortDescription,description,longDescription,rule)
  def prototype(key:String, data : List[T], shortDescription:String,description:String,longDescription:String,rule:SyntaxChecker[T]) = new BasicParameter[T](key,data,shortDescription,description,longDescription,rule)
  def set(value: List[T]): Parameter[T] = new BasicParameter[T](key,value,shortDescription,description,longDescription,rule)
  def set(value: T): Parameter[T] = new BasicParameter[T](key,List[T](value),shortDescription,description,longDescription,rule)
  def set(prop: Property[T]): Parameter[T] = new BasicParameter[T](prop.key,prop.data,shortDescription,description,longDescription,rule)
 
  def add(value: List[T]): Parameter[T] = new BasicParameter[T](key,data ++ value,shortDescription,description,longDescription,rule)
  def add(value: T): Parameter[T] = new BasicParameter[T](key,value :: data,shortDescription,description,longDescription,rule)
  def clear: BasicParameter[T] = new BasicParameter[T](key,Nil,shortDescription,description,longDescription,rule)  
  def compare(right: Parameter[T]): Int = {
    var answer:Int=0;
    answer = key.compareTo(right.key);
    if(answer !=0){
      return answer;
    }
    answer = data.lengthCompare(right.data.length)
    if (answer != 0) {
      return answer;
    }

    if(data.isEmpty){
      return -1;
    }
//        if(tag..isInstanceOf[Comparable]){
//          return 0;
//        }
//                if(tag.isInstanceOf[Ordered[T]]) {
//                  
//        for(pair : (T,T) <- data.zip(right.data)){
//          if(pair._1.asInstanceOf(Ordered). != pair._2){
//            return 1;
//          }
//        }
//                }
    0
  }
  def add(r:SyntaxChecker[T]):BasicParameter[T] = new BasicParameter[T](key,data,shortDescription,description,longDescription,r)
  def getObject: BasicParameter.type = BasicParameter;
};

class ConfigBasicParameter[T](implicit tag:TypeTag[T]) extends AbstractConfigGeneric{
    var key:ParameterInternal[String] = new BasicParameter[String](
        "ClassName", 
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
  
    var data:ParameterInternal[T] = new BasicParameter[T](
        "ClassName", 
        null,
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[T].setMinCount[T](1).setMaxCount[T](Int.MaxValue));
  
    var shortDescription:ParameterInternal[String] = new BasicParameter[String](
        "ClassName", 
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
  
    var description:ParameterInternal[String] = new BasicParameter[String](
        "ClassName", 
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
  
    var longDescription:ParameterInternal[String] = new BasicParameter[String](
        "ClassName", 
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );

     var rule:ParameterInternal[SyntaxChecker[T]] = new BasicParameter[SyntaxChecker[T]](
        "ClassName", 
        null,
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[SyntaxChecker[T]].setMinCount[SyntaxChecker[T]](1).setMaxCount[SyntaxChecker[T]](1)   );
  
        
};


object BasicParameter {
    
  def create[T](config:ConfigBasicParameter[T])(implicit tag:TypeTag[T]) : BasicParameter[T] = return new BasicParameter[T](
      config.key.data.head,
      config.data.data,
      config.shortDescription.data.head,
      config.description.data.head,
      config.longDescription.data.head,
      config.rule.data.head);
      
};

object ConfigBasicParameter {//extends AbstractConfigGeneric{
    var default:ParameterInternal[String] = new BasicParameter[String](
        "Default", 
        List("BasicParameter"),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1));
    
    var defaultSettings:ParameterInternal[ConfigBasicParameter[AnyRef]] = new BasicParameter[ConfigBasicParameter[AnyRef]](
        "Default", 
        null,
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        null);

//    var className:ParameterInternal[String] = new BasicParameter[String](
//        "ClassName", 
//        List("BasicParameter"),
//        "The Location of the name of the class to instantiate",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
//  
    var availableClasses:ParameterInternal[BasicParameter[String]] = new BasicParameter[BasicParameter[String]](
        "availableClasses",
        List(new BasicParameter[String]("",List(""),"","","",SyntaxChecker.create[String])),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[BasicParameter[String]].setMinCount[BasicParameter[String]](1).setMaxCount[BasicParameter[String]](Int.MaxValue) );
    
    def mapConfig[T](default:ParameterInternal[ConfigBasicParameter[AnyRef]])(implicit tag:TypeTag[T]):ParameterInternal[ConfigBasicParameter[T]] = return new BasicParameter[ConfigBasicParameter[T]](
        "Default", 
        List(new ConfigBasicParameter[T]),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[ConfigBasicParameter[T]].setMinCount[ConfigBasicParameter[T]](0).setMaxCount[ConfigBasicParameter[T]](Int.MaxValue));
    
    

    def prototype[T](implicit tag:TypeTag[T]):ConfigBasicParameter[T]  = new ConfigBasicParameter[T]

    def prototype[T](props:ParameterInternal[_ <: ConfigBasicParameter[T]] )(implicit tag:TypeTag[T]) : ConfigBasicParameter[T] = new ConfigBasicParameter[T]()

    
    def geParameter: List[Object] = {
      var ret : List[Object] = Nil
        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
          ret = entry :: ret
        }
        ret;
    }
    
    def getParameter(t:String): Object = {
        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
          if(entry.getName.equals(t)){
            return entry.get()
          }
        }
        return this;
    }
    
    def addType(t:String,proto:BasicParameter[String]): ConfigBasicParameter.type = {
        if(proto == null){
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
          throw new Exception("Null Factory Provided")
        }
        
        this.availableClasses = new BasicParameter[BasicParameter[String]](
            this.availableClasses.key,
            proto :: this.availableClasses.data,
            this.availableClasses.shortDescription,
            this.availableClasses.description,
            this.availableClasses.longDescription,
            this.availableClasses.rule);
        this;
//        if(t == null){
////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.dynamicfactory.property class name added");
//        }   
        
    }
    
    def check( props: AbstractConfigGeneric):Boolean = {
        var good:Boolean = true;
//        for(p <-  props.get() if !this.defaultSettings.check(p)){
//          false;
//        }
        true       
    }
    
    def check(parameter:Parameter[AnyRef]):Boolean = {
        // override with config specifics
        return true;
        //return properties.check(parameter);
    }

    def  getKnownTypes() : List[String] = List("BasicParameter");

    def  getClassParameter():String = "ClassName"

    val description :String = "Tooltip description here"

    def  getDescription(lang:String ):String = ""

    val longDescription:String= "Help File description here"

    def  getLongDescription(lang:String):String= "Help File description here"
   
    
    def create[T](implicit tag:TypeTag[T]):ParameterInternal[T] = return create[T](default.data.head,ConfigBasicParameter.mapConfig[T](ConfigBasicParameter.defaultSettings).data.head);

    def create[T](name:String)(implicit tag:TypeTag[T]):ParameterInternal[T] = return this.create[T](name,ConfigBasicParameter.mapConfig[T](ConfigBasicParameter.defaultSettings).data.head)
    
    def create[T](name:String, props:ConfigBasicParameter[T] )(implicit tag:TypeTag[T]):ParameterInternal[T]= {
      for(a <- ConfigBasicParameter.availableClasses.data if a.getClass.getName.equals(name)){
          return (a.getObject).create[T](props);
      }
      return BasicParameter.create[T](props);
    }
    
    def create[T]( props:Parameter[_ <: ConfigBasicParameter[T]])(implicit tag:TypeTag[T]) : ParameterInternal[T] = BasicParameter.create[T](props.data.head);
};






