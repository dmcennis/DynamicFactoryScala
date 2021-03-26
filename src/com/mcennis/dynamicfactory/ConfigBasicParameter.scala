package com.mcennis.dynamicfactory
//
//class ConfigBasicParameter extends AbstractConfigGeneric{
//// def add(t: String,value: List[AnyRef]): com.mcennis.dynamicfactory.PropertiesInternal = 
////  def add(t: String,value: com.mcennis.dynamicfactory.Parameter[AnyRef]): com.mcennis.dynamicfactory.PropertiesInternal = 
////  def add(t: String,value: com.mcennis.dynamicfactory.Property[AnyRef]): com.mcennis.dynamicfactory.PropertiesInternal = 
////  def add(t: String,value: AnyRef*): com.mcennis.dynamicfactory.PropertiesInternal = ???
////  def merge(props: com.mcennis.dynamicfactory.Properties): com.mcennis.dynamicfactory.PropertiesInternal = ???
////  def set(value: com.mcennis.dynamicfactory.Parameter[AnyRef]): com.mcennis.dynamicfactory.PropertiesInternal = ???
//  
//}
//
//object ConfigBasicParameter extends AbstractConfigGenericSingleton{
//      this.default.shortDescription = "BasicParameter"
////      default = BasicParameter.create[String]("Default", "BasicParameter");
//      this.default.shortDescription = "The default class type created in this factory"
//      this.default.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
//      this.default.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
//      this.default.rule = PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)
//    
//    
////    defaultSettings:ParameterInternal[AbstractConfigGeneric] = BasicParameter.create[AbstractConfigGeneric]("Default", new AbstractConfigGeneric);
//      this.defaultSettings.shortDescription = "The default class type created in this factory"
//      this.defaultSettings.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
//      this.defaultSettings.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
//      this.defaultSettings.rule = PropertyRestriction.create[ConfigBasicParameter].setMinCount[ConfigBasicParameter](0).setMaxCount[ConfigBasicParameter](Int.MaxValue);   
//
////    className:ParameterInternal[AbstractConfigGeneric] = BasicParameter.create[AbstractConfigGeneric]("ClassName", new AbstractConfigGeneric);
//    this.className.shortDescription = "The default class type created in this factory"
//    this.className.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
//    this.className.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
//    this.className.rule = PropertyRestriction.create[ConfigBasicParameter].setMinCount[ConfigBasicParameter](1).setMaxCount[ConfigBasicParameter](1)   
//  
////    availableClasses:ParameterInternal[AbstractConfigGeneric] = BasicParameter.create[AbstractConfigGeneric]("availableClasses",new AbstractConfigGeneric);
//    this.availableClasses.shortDescription = "The default class type created in this factory"
//    this.availableClasses.description = "When choosing between classes of a given interface, this variant is the default if no other is chosen"
//    this.availableClasses.longDescription = "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable."
//    this.availableClasses.rule = PropertyRestriction.create[ConfigBasicParameter].setMinCount[ConfigBasicParameter](1).setMaxCount[ConfigBasicParameter](Int.MaxValue)  
//    
//    
//
////  override def create[T](implicit tag : TypeTag[T]) : ParameterInternal[T] = new BasicParameter[T]("",Nil)
////  override def create[T](s: String, t : T* )(implicit tag : TypeTag[T]) : BasicParameter[T] = new BasicParameter[T]("",Nil)//s,t.toList);
////  override def create[T](s: String, t : List[T] )(implicit tag : TypeTag[T]) : BasicParameter[T] = new BasicParameter[T]("",Nil)//(s,t);
//  def create[T](props:ParameterInternal[_ <: ConfigBasicParameter] )(implicit tag:TypeTag[T]): ParameterInternal[T] = new BasicParameter[T](props.key,Nil)//props.data)
// // override def create[T](param :Property[T])(implicit tag : TypeTag[T]) : BasicParameter[T] = BasicParameter.create[T](param.key,param.data);
//  
//  
//}