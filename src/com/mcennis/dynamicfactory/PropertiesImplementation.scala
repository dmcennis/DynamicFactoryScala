package com.mcennis.dynamicfactory

class PropertiesImplementation extends PropertiesInternal{

  var map : Map[String,Parameter[AnyRef]] = Map[String,ParameterInternal[AnyRef]]()
  
  def check(props: com.mcennis.dynamicfactory.Properties): Boolean = {
    for( prop <- props.get()){
      if(!prop.rule.check){
        return false;
      }
    }
    return true;
  }
  def check(t: com.mcennis.dynamicfactory.Parameter[AnyRef]): Boolean = {
    if(map.contains(t.key)){
      return map.get(t.key).get.rule.check(t);
    }else{
      return false;
    }
  }
  def get(s: String): com.mcennis.dynamicfactory.Parameter[AnyRef] = {
    if((!map.get(s).isEmpty)&&(map.get(s).get.rule.check)){
      val ret : Parameter[AnyRef] = BasicParameter.create[AnyRef]("",Nil);
      return ret;
    }else{
      return map.get(s).get;
    }
  }
  def get(): List[com.mcennis.dynamicfactory.Parameter[AnyRef]] = ???
//  def getDefaultRestriction(): com.mcennis.dynamicfactory.SyntaxChecker = ???
  def getQuick(s: String): Parameter[AnyRef] = map.get(s).get
  def merge(props: Properties): PropertiesInternal = {
    var ret : PropertiesInternal = PropertiesImplementation.create();
    for(param <- map.values){
      if(props.map.contains(param.key)){
        if(!param.classType.equals(props.get(param.key).classType)){
          throw new InvalidObjectTypeException//(param.key+" conflicts between type "+tag.name+" and "+props.tag.name  );
        }
        if(param.rule.check(props.get(param.key))){
          throw new SyntaxErrorException//(param,props.get(param.key));
        }
        ret.map = ret.map - param.key
        ret.map = ret.map + (param.key -> Parameter.create[AnyRef](param.key,param.data ++ props.get(param.key).data))
      }else{
        ret.map = ret.map + (param.key -> param)  
      }
      
    }
    for(param <- props.map.keys; if (!map.contains(param))){ 
      ret.map = ret.map. +(param -> props.get(param));
    }
    return ret;
  }
  def mergeDefaults(props: com.mcennis.dynamicfactory.Properties): com.mcennis.dynamicfactory.PropertiesInternal = {
    var ret : PropertiesInternal = this.merge(props);
    // TODO: Default Properties files on factory objects
    return ret;
  }
  def prototype(): Properties = PropertiesImplementation.create();
//  def quickGet(s: String): Parameter[AnyRef] = getQuick(s)
  def set(value: Parameter[AnyRef]): PropertiesInternal = {
      map = map + (value.key -> Parameter.create[AnyRef](value));
      return this;
  }
  
}

object PropertiesImplementation {
  def create() : PropertiesImplementation = new PropertiesImplementation();
}