package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._


class BasicParameter[T] (key:String, data : List[T])(implicit tag : TypeTag[T])extends ParameterInternal[T](key,data) {
  def prototype[T](key:String, data : List[T])(implicit tag : TypeTag[T]):Parameter[T] = new BasicParameter[T](key,data)
  def set(value: List[T]): Parameter[T] = BasicParameter.create[T](key, value )
  def set(value: T): Parameter[T] = BasicParameter.create[T](key,value)
  def set(prop: Property[T]): Parameter[T] = new BasicParameter[T](prop.key,prop.data)
 
  def add(value: List[T]): Parameter[T] = new BasicParameter[T](key,data ++ value)
  def add(value: T): Parameter[T] = new BasicParameter[T](key,value :: data)
  def clear: BasicParameter[T] = new BasicParameter[T](key,Nil)  
  def compare(right: Parameter[T]): Int = {
    var answer:Int=0;
    answer = key.compareTo(right.key);
    if(answer !=0){
      return answer;
    }
    answer = data.lengthCompare(right.data.length)
    if (answer != 0) {
      return answer;
    }

    if(data.isEmpty){
      return -1;
    }
//        if(tag..isInstanceOf[Comparable]){
//          return 0;
//        }
//                if(tag.isInstanceOf[Ordered[T]]) {
//                  
//        for(pair : (T,T) <- data.zip(right.data)){
//          if(pair._1.asInstanceOf(Ordered). != pair._2){
//            return 1;
//          }
//        }
//                }
    0
  }

}

object BasicParameter {

  def create[T](implicit tag : TypeTag[T]) : ParameterInternal[T] = new BasicParameter[T]("",Nil);
  def create[T](s: String, t : T* )(implicit tag : TypeTag[T]) : BasicParameter[T] = new BasicParameter[T](s,t.toList);
  def create[T](s: String, t : List[T] )(implicit tag : TypeTag[T]) : BasicParameter[T] = new BasicParameter[T](s,t);
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : BasicParameter[T] = BasicParameter.create[T](param.key,param.data);
  def create[T](param :Property[T])(implicit tag : TypeTag[T]) : BasicParameter[T] = BasicParameter.create[T](param.key,param.data);
  
}