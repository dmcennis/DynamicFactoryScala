package com.mcennis.dynamicfactory

import scala.collection.mutable.HashMap
import java.lang.reflect.Field

trait factory[Type] {
//    var default:ParameterInternal[String] = BasicParameter.create[String]("Default", "BasicParameter");
////      default.shortDescription = "The default class type created in this factory"
////      default.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
////      default.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
////      default.rule = PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   
////    
//    var defaultSettings:ParameterInternal[AbstractConfigGeneric] = BasicParameter.create[AbstractConfigGeneric]("Default", new AbstractConfigGeneric);
////      defaultSettings.shortDescription = "The default class type created in this factory"
////      defaultSettings.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
////      defaultSettings.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
////      defaultSettings.rule = PropertyRestriction.create[AbstractFactory].setMinCount[AbstractFactory](0).setMaxCount[AbstractFactory](Int.MaxValue);   
////
//    var className:ParameterInternal[AbstractConfigGeneric] = BasicParameter.create[AbstractConfigGeneric]("ClassName", new AbstractConfigGeneric);
////    className.shortDescription = "The default class type created in this factory"
////    className.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
////    className.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
////    className.rule = PropertyRestriction.create[AbstractFactory].setMinCount[AbstractFactory](1).setMaxCount[AbstractFactory](1)   
////  
//    var availableClasses:ParameterInternal[AbstractConfigGeneric] = BasicParameter.create[AbstractConfigGeneric]("availableClasses",new AbstractConfigGeneric);
////    availableClasses.shortDescription = "The default class type created in this factory"
////    availableClasses.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
////    availableClasses.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
////    availableClasses.rule = PropertyRestriction.create[AbstractFactory].setMinCount[AbstractFactory](1).setMaxCount[AbstractFactory](Int.MaxValue)   
////    
////    def create[T]( props:Parameter[_ <: AbstractFactory]) : T;// = {
//////        if((props != null)&&(props.quickCheck("ClassName"))){
//////            className match {
//////              case name : String => 
//////                return map.get(name).getOrElse(
//////                    return this.map.get("Default").getOrElse(
//////                        throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults")).create[T](props)).create[T](props)
//////              case _ => return this.map.get("Default").getOrElse(
//////                        throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults")).create[T](props)
//////            }
//////
//////            
////////            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,String.format("Class %s is unknown. Using the default instead", props.quickGet("ClassName")));
//////            properties.getQuick("Default") match{
//////               case name: String =>  return map.get(name).get.prototype(props).create(props);
//////            }
////////            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Class parameter is missing. Using the default instead");
//////        }
//////            properties.getQuick("Default") match{
//////              case name:String => return map.get(name).get.prototype(props).create(properties);
//////              case _ => throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults");
//////            }
//////        
//////    }
////
//    def create[T]:T ;//= {
////        return create[T](defaultSettings);
////    }
////
//    def create[T](name:String):T; //= return create[T](name,defaultSettings)
////    
////
//    def create[T](name:String, props:ParameterInternal[_ <: AbstractFactory] ):T ;//= {
////        props.data.head.className.set(name);
////        return create[T](props);
////    }
////
//    def prototype():factory[Type];//  = this
////
//    def prototype(props:ParameterInternal[_ <: AbstractFactory] ) : factory[Type];// = {
////        return prototype();
////    }
////
//    def setDefaultSettings(value:ParameterInternal[AbstractFactory]):factory[Type];// = {
////        defaultSettings = value;
////        this
////    }
////    
//    def getDefaultParameters():AbstractFactory = defaultSettings.data.head
////    
//    def geParameter: List[Object] = {
////      var ret : List[Object] = Nil
////        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
////          ret = entry :: ret
////        }
////        ret;
////    }
////    
//    def getParameter(t:String): Object = {
////        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
////          if(entry.getName.equals(t)){
////            return entry.get()
////          }
////        }
////        return this;
////    }
////    
//    def addType(t:String,proto:AbstractFactory): factory[Type] = {
//////        availableClasses.data
////        if(proto == null){
//////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
////          throw new Exception("Null Factory Provided")
////        }
////        
////        this.availableClasses.data = proto :: this.availableClasses.data;
////        this;
//////        if(t == null){
////////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.dynamicfactory.property class name added");
//////        }   
////        
//////        map.put(t,proto);
//////        proto
////    }
////    
////    def check( props: AbstractFactory):Boolean = {
////        var good:Boolean = true;
//////        for(p <-  props.get() if !this.defaultSettings.check(p)){
//////          false;
//////        }
////        true       
////    }
////    
////    def check(parameter:Parameter[AnyRef]):Boolean = {
////        // override with config specifics
////        return true;
////        //return properties.check(parameter);
////    }
////
////    def  getKnownTypes() : List[String] = List("BasicParameter");
////
////    def  getClassParameter():String = "ClassName"
////
////    val description :String = "Tooltip description here"
////
////    def  getDescription(lang:String ):String = ""
////
////    val longDescription:String= "Help File description here"
////
////    def  getLongDescription(lang:String):String= "Help File description here"
////  
}