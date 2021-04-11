package com.mcennis.dynamicfactory

import java.lang.reflect.Field
import scala.reflect.runtime.universe._


class AbstractConfig {
    var className:BasicParameter[String] = new BasicParameter[String](
        "ClassName", 
        List("ClassName"),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1) );
    
    def this (copy : AbstractConfig){
      this
      className = copy.className
    }
    
    def check(props: AbstractConfig): Boolean = true
    def check(t: com.mcennis.dynamicfactory.Parameter[AnyRef]): Boolean = t.rule.check;
    def get(): List[String] = List("default","defaultSettings","className")
    def prototype(): AbstractConfig = this;
    def quickCheck[Value](S: String)(implicit tag: reflect.runtime.universe.TypeTag[Value]): Boolean =  {
//      if((S == "default")&&(tag.equals(AbstractConfig.default.classType))){
//        return true;
//      }
//      if((S == "defaultSettings")&&(tag.equals(AbstractConfig.defaultSettings.classType))){
//        return true;
//      }
//      if((S == "className")&&(tag.equals(AbstractConfig.className.classType))){
//        return true;
//      }
      return false;
    }
    def getObject : AbstractConfig.type = AbstractConfig;
}

object AbstractConfig {
//    var default:ParameterInternal[String] = new BasicParameter[String](
//        "Default", 
//        List("BasicParameter"),
//        "The default class type created in this factory",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1));
//         
//    
//    var defaultSettings:ParameterInternal[AbstractConfig] = new BasicParameter[AbstractConfig](
//        "Default", 
//        List(new AbstractConfig),
//        "The default class type created in this factory",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[AbstractConfig].setMinCount[AbstractConfig](0).setMaxCount[AbstractConfig](Int.MaxValue));
//
//    var className:ParameterInternal[AbstractConfig] = new BasicParameter[AbstractConfig](
//        "ClassName", 
//        List(new AbstractConfig),
//        "The default class type created in this factory",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[AbstractConfig].setMinCount[AbstractConfig](1).setMaxCount[AbstractConfig](1)   );
//  
//    var availableClasses:ParameterInternal[AbstractConfig] = new BasicParameter[AbstractConfig](
//        "availableClasses",
//        List(new AbstractConfig),
//        "The default class type created in this factory",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[AbstractConfig].setMinCount[AbstractConfig](1).setMaxCount[AbstractConfig](Int.MaxValue) );
//    
//    def create( props:Parameter[_ <: AbstractConfig]) : AbstractConfig = {
////      BasicParameter.create("Default Object",Nil)
//      new AbstractConfig
//    }
////        if((props != null)&&(props.quickCheck("ClassName"))){
////            className match {
////              case name : String => 
////                return map.get(name).getOrElse(
////                    return this.map.get("Default").getOrElse(
////                        throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults")).create(props)).create(props)
////              case _ => return this.map.get("Default").getOrElse(
////                        throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults")).create(props)
////            }
////
////            
//////            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,String.format("Class %s is unknown. Using the default instead", props.quickGet("ClassName")));
////            properties.getQuick("Default") match{
////               case name: String =>  return map.get(name).get.prototype(props).create(props);
////            }
//////            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Class parameter is missing. Using the default instead");
////        }
////            properties.getQuick("Default") match{
////              case name:String => return map.get(name).get.prototype(props).create(properties);
////              case _ => throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults");
////            }
////        
////    }
//
//    def create: AbstractConfig = {
//        return create(defaultSettings);
//    }
//
//    def create(name:String):AbstractConfig = return create(name,defaultSettings)
//
//    def create(name:String, props:ParameterInternal[_ <: AbstractConfig] ):AbstractConfig= {
//        props.data.head.className.set(name);
//        return create(props);
//    }
//
//    def prototype():AbstractConfig  = new AbstractConfig
//
//    def prototype(props:ParameterInternal[_ <: AbstractConfig] ) : AbstractConfig = new AbstractConfig(props.data.head)
//
//    def setDefaultSettings(value:ParameterInternal[AbstractConfig]):AbstractConfig.type = {
//        defaultSettings = value;
//        this
//    }
//    
//    def getDefaultParameters():AbstractConfig = defaultSettings.data.head
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
//    def addType(t:String,proto:AbstractConfig): AbstractConfig.type = {
////        availableClasses.data
//        if(proto == null){
////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
//          throw new Exception("Null Factory Provided")
//        }
//        
//        this.availableClasses = new BasicParameter[AbstractConfig](
//            availableClasses.key, 
//            proto :: this.availableClasses.data,
//            this.availableClasses.shortDescription,
//            this.availableClasses.description,
//            this.availableClasses.longDescription,
//            this.availableClasses.rule);
//        proto.getObject;
//    }
//    
//    def check( props: AbstractConfig):Boolean = {
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
////    def  getKnownTypes() : List[AbstractConfig.type] = this.availableClasses.data.flatMap[AbstractConfig,AbstractConfig.type]()();
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
////    private def getType(a:AbstractConfig): AbstractType.type
}

