package com.mcennis.dynamicfactory

import scala.collection.mutable.HashMap

trait factory[Type] {
    def  map:HashMap[String,factory[Type]] = new HashMap[String,factory[Type]];
    def properties:PropertiesInternal  = new PropertiesImplementation();
    
    def create[T]( props:Properties) : T = {
        if((props != null)&&(props.quickCheck("ClassName"))){
            props.quickGet("ClassName") match {
              case name : String => 
                return map.get(name).getOrElse(
                    return this.map.get("Default").getOrElse(
                        throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults")).create[T](props)).create[T](props)
              case _ => return this.map.get("Default").getOrElse(
                        throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults")).create[T](props)
            }

            
//            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,String.format("Class %s is unknown. Using the default instead", props.quickGet("ClassName")));
            properties.getQuick("Default") match{
               case name: String =>  return map.get(name).get.prototype(props).create(props);
            }
//            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Class parameter is missing. Using the default instead");
        }
            properties.getQuick("Default") match{
              case name:String => return map.get(name).get.prototype(props).create(properties);
              case _ => throw new Exception("INTERNAL SYSTEM: No constructors found for this object - including defaults");
            }
        
    }

    def create[T]:T = {
        return create[T](properties);
    }

    def create[T](name:String):T = return create[T](name,properties)
    

    def create[T](name:String, props:PropertiesInternal ):T = {
//        try {
            props.add("FactoryName",name);
//        } catch (InvalidObjectTypeException e) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"DEVELOPER(this.getClass().getName()): FactoryName property passed to this Factory should not have a property 'FactoryName' of type other than string");
//        }
        return create[T](props);
    }

    def prototype():factory[Type]  = this

    def prototype(props:Properties ) : factory[Type] = {
        return prototype();
    }

    def setDefaultProperty(value:ParameterInternal[AnyRef]):factory[Type] = {
        properties.set(value);
        return this;
    }
    
    def addDefaultProperty(t:String, value:AnyRef) : factory[Type] = {
        properties.add(t,value)
        this
    }

    def getParameter():Properties = properties
    
    def getParameter(t:String):Parameter[AnyRef] = {
        properties.get(t)
    }
    
    def addType(t:String,proto:factory[Type]): factory[Type] = {
        if(t == null){
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.dynamicfactory.property class name added");
        }   
        if(proto == null){
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
        }
        
        map.put(t,proto);
        proto
    }
    
    def check( props:Properties):Boolean = {
        var good:Boolean = true;
        for(p <-  props.get() if !properties.check(p)){
          false;
        }
        true       
    }
    
    def check(parameter:Parameter[AnyRef]):Boolean = {
        return properties.check(parameter);
    }

    def  getKnownTypes() : List[String] = return (map.keySet).toList;

    def  getClassParameter():Parameter[AnyRef] = properties.get("Classname")


    def  getDescription():String = "Tooltip description here"

    def  getDescription(lang:String ):String = ""

    def  getLongDescription():String= "Help File description here"

    def  getLongDescription(lang:String):String= "Help File description here"
  
}