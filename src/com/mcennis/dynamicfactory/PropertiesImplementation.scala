package com.mcennis.dynamicfactory

//trait PropertiesImplementation extends PropertiesInternal{
//  
//  def check(props: com.mcennis.dynamicfactory.Properties): Boolean = {
////    if(!props.check()){
////      return false
////    }
//    // Should be overridden in derivative class using class parameters
//    return true;
//  }
//  def check(t: com.mcennis.dynamicfactory.Parameter[AnyRef]): Boolean = {
//    if(!t.rule.check){
//      return false;
//    }
//    // Should be overridden in derivative class using class parameters
//    return true;
//  }
//  
////  def get(s: String): com.mcennis.dynamicfactory.Parameter[AnyRef] = {
////    if((!map.get(s).isEmpty)&&(map.get(s).get.rule.check)){
////      val ret : Parameter[AnyRef] = BasicParameter.create[AnyRef]("",Nil);
////      return ret;
////    }else{
////      return map.get(s).get;
////    }
////  }
//  def get(): List[String] = List("default","defaultSettings")
////  def getDefaultRestriction(): com.mcennis.dynamicfactory.SyntaxChecker = ???
////  def getQuick(s: String): Parameter[AnyRef] = map.get(s).get
////  def merge(props: Properties): PropertiesInternal = {
////    var ret : PropertiesInternal = PropertiesImplementation.create();
////    for(param <- map.values){
////      if(props.map.contains(param.key)){
////        if(!param.classType.equals(props.get(param.key).classType)){
////          throw new InvalidObjectTypeException//(param.key+" conflicts between type "+tag.name+" and "+props.tag.name  );
////        }
////        if(param.rule.check(props.get(param.key))){
////          throw new SyntaxErrorException//(param,props.get(param.key));
////        }
////        ret.map = ret.map - param.key
////        ret.map = ret.map + (param.key -> Parameter.create[AnyRef](param.key,param.data ++ props.get(param.key).data))
////      }else{
////        ret.map = ret.map + (param.key -> param)  
////      }
////      
////    }
////    for(param <- props.map.keys; if (!map.contains(param))){ 
////      ret.map = ret.map. +(param -> props.get(param));
////    }
////    return ret;
////  }
//  def mergeDefaults(props: com.mcennis.dynamicfactory.Properties): com.mcennis.dynamicfactory.PropertiesInternal = {
//    var ret : PropertiesInternal = this.merge(props);
//    // TODO: Default Properties files on factory objects
//    return ret;
//  }
//  def prototype(): Properties;
////  def quickGet(s: String): Parameter[AnyRef] = getQuick(s)
////  def set(value: Parameter[AnyRef]): PropertiesInternal = {
////      map = map + (value.key -> Parameter.create[AnyRef](value));
////      return this;
////  }
//  
////      def add(t:String,value:AnyRef*) : PropertiesInternal = add(t,Parameter.create[AnyRef](t,value))
////      def add(t:String,value:Property[AnyRef]) : PropertiesInternal = add(t,Parameter.create[AnyRef](t,value))
////      def add(t:String,value:List[AnyRef]) : PropertiesInternal = add(t,Parameter.create(t,value))
////      def add(t:String,value:Parameter[AnyRef]) : PropertiesInternal = {
////        if((t!=null) && (value!=null)){
////          map.get(t).get.data = map.get(t).get.data ::: value.data;
////        }
////        this
////      }
//      
////  def getDefaultRestriction(): com.mcennis.dynamicfactory.SyntaxChecker[AnyRef] = restrictions
////  def quickCheck[Value](s: String)(implicit tag: reflect.runtime.universe.TypeTag[Value]): Boolean = {
////    if(s!=null){
////      if(map.contains(s)){
////        if(map.get(s).get.classType==tag){
////          if(!map.get(s).get.data.isEmpty){
////            return true;
////          }
////        }
////      }
////    }
////    false
////  }
//  
//}
//
//object PropertiesImplementation  {//extends factory[PropertiesImplementation]{
//   def create[T](implicit tag:TagType[T]) : PropertiesImplementation = BasicParameter.create[T];
//}