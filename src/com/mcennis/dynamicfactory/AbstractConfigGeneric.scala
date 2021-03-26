package com.mcennis.dynamicfactory

import java.lang.reflect.Field

import scala.reflect.runtime.universe._


class AbstractConfigGeneric {//extends PropertiesImplementation{
    var className:ParameterInternal[AbstractConfigGeneric] = new BasicParameter[AbstractConfigGeneric](
        "ClassName", 
        List(new AbstractConfigGeneric),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[AbstractConfigGeneric].setMinCount[AbstractConfigGeneric](1).setMaxCount[AbstractConfigGeneric](1)   );
   

    def this (copy : AbstractConfigGeneric){
      this
      className = copy.className
    }
    
    def check(props: AbstractConfigGeneric): Boolean = true
    def check(t: com.mcennis.dynamicfactory.Parameter[AnyRef]): Boolean = t.rule.check;
    def get(): List[String] = List("default","defaultSettings","className")
    def prototype(): AbstractConfigGeneric = this;
    def quickCheck[Value](S: String)(implicit tag: reflect.runtime.universe.TypeTag[Value]): Boolean =  {
      if((S == "default")&&(tag.equals(AbstractConfigGeneric.default.classType))){
        return true;
      }
      if((S == "defaultSettings")&&(tag.equals(AbstractConfigGeneric.defaultSettings.classType))){
        return true;
      }
//      if((S == "className")&&(tag.equals(AbstractConfigGeneric.className.classType))){
//        return true;
//      }
      return false;
    }
    def getObject : AbstractConfigGeneric.type = AbstractConfigGeneric;
}

object AbstractConfigGeneric {//extends AbstractConfigGenericSingleton{
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
  
    var availableClasses:ParameterInternal[AbstractConfigGeneric] = new BasicParameter[AbstractConfigGeneric](
        "availableClasses",
        List(new AbstractConfigGeneric),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[AbstractConfigGeneric].setMinCount[AbstractConfigGeneric](1).setMaxCount[AbstractConfigGeneric](Int.MaxValue) );

  
  
}

