package com.mcennis.dynamicfactory

import java.lang.reflect.Field

import scala.reflect.runtime.universe._


abstract class AbstractConfigGenericSingleton {
    var default:ParameterInternal[String] = new BasicParameter[String](
        "Default", 
        List("BasicParameter"),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1));
    
    var defaultSettings:ParameterInternal[AbstractConfigGeneric] = new BasicParameter[AbstractConfigGeneric](
        "Default", 
        List(new AbstractConfigGeneric),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[AbstractConfigGeneric].setMinCount[AbstractConfigGeneric](0).setMaxCount[AbstractConfigGeneric](Int.MaxValue));

    var className:ParameterInternal[AbstractConfigGeneric] = new BasicParameter[AbstractConfigGeneric](
        "ClassName", 
        List(new AbstractConfigGeneric),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[AbstractConfigGeneric].setMinCount[AbstractConfigGeneric](1).setMaxCount[AbstractConfigGeneric](1)   );
  
    var availableClasses:ParameterInternal[AbstractConfigGeneric] = new BasicParameter[AbstractConfigGeneric](
        "availableClasses",
        List(new AbstractConfigGeneric),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[AbstractConfigGeneric].setMinCount[AbstractConfigGeneric](1).setMaxCount[AbstractConfigGeneric](Int.MaxValue) );
   
    def create[T]( props:Parameter[_ <: AbstractConfigGeneric])(implicit tag:TypeTag[T]) : ParameterInternal[T] = {
      new BasicParameter[T](props.data.head.className.key,Nil,"","","",SyntaxChecker.create[T])
    }

    def create[T](implicit tag:TypeTag[T]):ParameterInternal[T] = {
        return create[T](defaultSettings);
    }

//    def create[T](name:String)(implicit tag:TypeTag[T]):ParameterInternal[T] = return create[T](name,defaultSettings)
    

//    def create[T](name:String, props:ParameterInternal[_ <: AbstractConfigGeneric] )(implicit tag:TypeTag[T]):ParameterInternal[T]= {
//        props.data.head.className.set(name);
//        return create[T](props);
//    }

    def prototype():AbstractConfigGeneric  = new AbstractConfigGeneric

    def prototype(props:ParameterInternal[_ <: AbstractConfigGeneric] ) : AbstractConfigGeneric = new AbstractConfigGeneric(props.data.head)

    def setDefaultSettings(value:ParameterInternal[AbstractConfigGeneric]):AbstractConfigGenericSingleton = {
        defaultSettings = value;
        this
    }
    
    def getDefaultParameters():AbstractConfigGeneric = defaultSettings.data.head
    
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
    
    def addType(t:String,proto:AbstractConfigGeneric): AbstractConfigGenericSingleton = {
//        availableClasses.data
        if(proto == null){
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
          throw new Exception("Null Factory Provided")
        }
        
     //   this.availableClasses.data = proto :: this.availableClasses.data;
        this;
//        if(t == null){
////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.dynamicfactory.property class name added");
//        }   
        
//        map.put(t,proto);
//        proto
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
  

}