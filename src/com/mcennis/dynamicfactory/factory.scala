package com.mcennis.dynamicfactory

import scala.collection.mutable.HashMap

trait factory[Type] {
    def  map:HashMap[String,Type with factory[Type]] = new HashMap[String,T with factory[Type]];
    def properties:PropertiesInternal  = new PropertiesImplementation();
    
    def create[Type]( props:Properties) : Type = {
        if((props != null)&&(props.quickCheck("ClassName"))){
            props.quickGet("ClassName") match {
              case name : String => 
                return map.get(name).getOrElse(return this.create).prototype(props)
            }

            
            if(map.contains(props.quickGet("ClassName"))) {
                return map.get(props.quickGet("ClassName")).prototype(props);
            }else{
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING,String.format("Class %s is unknown. Using the default instead", props.quickGet("ClassName")));
                properties.getQuick("Default") match{
                  case name: String =>  return map.get(name).get.prototype(props);
                }
                return map.get(name).prototype(props);
            }
        }
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Class parameter is missing. Using the default instead");
            val name:String = (String)properties.getQuick("Default");
            return map.get(name).get.prototype(props);
        
    }

    def create[Type]:Type = {
        return create(properties);
    }

    def create[Type](name:String):Type = {
        var p: Properties = properties.prototype()
        p match {
          case props: PropertiesInternal => create[Type](name,props.mergeDefaults(properties))
        }
        return create[Type](name,properties);
    }

    def create[Type](name:String, props:PropertiesInternal ):Type = {
        try {
            props.add("FactoryName",name);
        } catch (InvalidObjectTypeException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"DEVELOPER(this.getClass().getName()): FactoryName property passed to this Factory should not have a property 'FactoryName' of type other than string");
        }
        return create(props);
    }

    def prototype():factory[Type] ;

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
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.dynamicfactory.property class name added");
        }   
        if(proto == null){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
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