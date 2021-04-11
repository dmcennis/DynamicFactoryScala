package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._
import scala.collection.immutable.List
import java.lang.reflect.Field
// TODO Fix This
//class BasicProperty[T] (key:String, data : List[T])(implicit tag : TypeTag[T]) extends Property(key:String, data : List[T]) {
////  rule = PropertyRestriction
//  def prototype(key:String, data : List[T]):Property[T] = new BasicProperty[T](key,data)
//  def set(value: List[T]): Property[T] = new BasicProperty[T](key,value)
//  def set(value: T): Property[T] = new BasicProperty[T](key,List[T](value))
//  def set(prop: Property[T]): Property[T] = new BasicProperty[T](prop.key,prop.data)
// 
//  def add(value: List[T]): Property[T] = new BasicProperty[T](key,data ++ value)
//  def add(value: T): Property[T] = new BasicProperty[T](key,value :: data)
//  def clear: BasicProperty[T] = new BasicProperty[T](key,Nil)  
//  def compare(right: Property[T]): Int = {
//    var answer:Int=0;
//    answer = key.compareTo(right.key);
//    if(answer !=0){
//      return answer;
//    }
//    answer = data.lengthCompare(right.data.length)
//    if (answer != 0) {
//      return answer;
//    }
//
//    if(data.isEmpty){
//      return -1;
//    }
////        if(tag..isInstanceOf[Comparable]){
////          return 0;
////        }
////                if(tag.isInstanceOf[Ordered[T]]) {
////                  
////        for(pair : (T,T) <- data.zip(right.data)){
////          if(pair._1.asInstanceOf(Ordered). != pair._2){
////            return 1;
////          }
////        }
////                }
//    0
//  }
//  def getObject: BasicProperty.type = BasicProperty;
//  def prototype():Property[T] = return new BasicProperty(key,data);
//};
//
//class ConfigBasicProperty[T](implicit tag:TypeTag[T]) extends AbstractConfigGeneric{
//    val className:Parameter[String] = new BasicParameter[String](
//        "ClassName", 
//        List("BasicParameter"),
//        "The Location of the name of the class to instantiate",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
//  
//    val key:Parameter[String] = new BasicParameter[String](
//        "ClassName", 
//        List("Default"),
//        "The Location of the name of the class to instantiate",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
//  
//    val data:Parameter[T] = new BasicParameter[T](
//        "ClassName", 
//        null,
//        "The Location of the name of the class to instantiate",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[T].setMinCount[T](1).setMaxCount[T](Int.MaxValue));
//  
////    val shortDescription:ParameterInternal[String] = new BasicParameter[String](
////        "ClassName", 
////        List("Default"),
////        "The Location of the name of the class to instantiate",
////        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
////        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
////        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
////  
////    val description:ParameterInternal[String] = new BasicParameter[String](
////        "ClassName", 
////        List("Default"),
////        "The Location of the name of the class to instantiate",
////        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
////        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
////        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
////  
////    val longDescription:ParameterInternal[String] = new BasicParameter[String](
////        "ClassName", 
////        List("Default"),
////        "The Location of the name of the class to instantiate",
////        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
////        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
////        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
//
//  
// // def getObject: ConfigBasicProperty.type = ConfigBasicProperty;
//        
//};
//
//object BasicProperty {//extends factory[BasicProperty[AnyRef]]{
//  def create[T](config:ConfigBasicProperty[T])(implicit tag:TypeTag[T]) : BasicProperty[T] = return new BasicProperty[T](
//      config.key.data.head,
//      config.data.data);
//};
//
//object ConfigBasicProperty {//extends AbstractConfigGeneric{
//    var default:Parameter[String]=null; //= new BasicParameter[String](
////        "Default", 
////        List("BasicParameter"),
////        "The default class type created in this factory",
////        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
////        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
////        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1));
//    
//    var defaultSettings:Parameter[ConfigBasicProperty[AnyRef]]=null; //= new BasicParameter[ConfigBasicProperty[AnyRef]](
////        "Default", 
////        null,
////        "The default class type created in this factory",
////        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
////        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
////        null);
//
////    var className:ParameterInternal[String] = new BasicParameter[String](
////        "ClassName", 
////        List("BasicParameter"),
////        "The Location of the name of the class to instantiate",
////        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
////        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
////        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
////  
//    var availableClasses:Parameter[BasicProperty[String]] = new BasicParameter[BasicProperty[String]](
//        "availableClasses",
//        List(new BasicProperty[String]("",List(""))),
//        "The default class type created in this factory",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[BasicProperty[String]].setMinCount[BasicProperty[String]](1).setMaxCount[BasicProperty[String]](Int.MaxValue) );
//    
//    def mapConfig[T](default:Parameter[ConfigBasicProperty[AnyRef]])(implicit tag:TypeTag[T]):Parameter[ConfigBasicProperty[T]] = return new BasicParameter[ConfigBasicProperty[T]](
//        "Default", 
//        List(new ConfigBasicProperty[T]),
//        "The default class type created in this factory",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[ConfigBasicProperty[T]].setMinCount[ConfigBasicProperty[T]](0).setMaxCount[ConfigBasicProperty[T]](Int.MaxValue));
//    
//    
//
//    def prototype[T](implicit tag:TypeTag[T]):ConfigBasicProperty[T]  = new ConfigBasicProperty[T];
//
//    def prototype[T](props:Parameter[_ <: ConfigBasicProperty[T]] )(implicit tag:TypeTag[T]) : ConfigBasicProperty[T] = new ConfigBasicProperty[T]()
//
//    
//    def geParameter: List[Object] = {
//      var ret : List[Object] = Nil
//        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
//          ret = entry :: ret
//        }
//        ret;
//    }
//    
//    def getParameter(t:String): Object = {
//        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
//          if(entry.getName.equals(t)){
//            return entry.get()
//          }
//        }
//        return this;
//    }
//    
//    def addType(t:String,proto:BasicProperty[String]): ConfigBasicProperty.type = {
//        if(proto == null){
////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
//          throw new Exception("Null Factory Provided")
//        }
//        
//        this.availableClasses = new BasicParameter[BasicProperty[String]](
//            this.availableClasses.key,
//            proto :: this.availableClasses.data,
//            this.availableClasses.shortDescription,
//            this.availableClasses.description,
//            this.availableClasses.longDescription,
//            this.availableClasses.rule);
//        this;
////        if(t == null){
//////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.dynamicfactory.property class name added");
////        }   
//        
//    }
//    
//    def check( props: AbstractConfigGeneric):Boolean = {
//        var good:Boolean = true;
////        for(p <-  props.get() if !this.defaultSettings.check(p)){
////          false;
////        }
//        true       
//    }
//    
//    def check(parameter:Parameter[AnyRef]):Boolean = {
//        // override with config specifics
//        return true;
//        //return properties.check(parameter);
//    }
//
//    def  getKnownTypes() : List[String] = List("BasicProperty");
//
//    def  getClassParameter():String = "ClassName"
//
//    val description :String = "Tooltip description here"
//
//    def  getDescription(lang:String ):String = ""
//
//    val longDescription:String= "Help File description here"
//
//    def  getLongDescription(lang:String):String= "Help File description here"
//   
//    
//    def create[T](implicit tag:TypeTag[T]):Property[T] = return create[T](default.data.head,ConfigBasicProperty.mapConfig[T](ConfigBasicProperty.defaultSettings).data.head);
//
//    def create[T](name:String)(implicit tag:TypeTag[T]):Property[T] = return this.create[T](name,ConfigBasicProperty.mapConfig[T](ConfigBasicProperty.defaultSettings).data.head)
//    
//    def create[T](name:String, props:ConfigBasicProperty[T] )(implicit tag:TypeTag[T]):Property[T]= {
//      for(a <- ConfigBasicProperty.availableClasses.data if a.getClass.getName.equals(name)){
//          return (a.getObject).create[T](props);
//      }
//      return BasicProperty.create[T](props);
//    }
//    
//    def create[T]( props:Parameter[_ <: ConfigBasicProperty[T]])(implicit tag:TypeTag[T]) : Property[T] = BasicProperty.create[T](props.data.head);
//};
//
//




