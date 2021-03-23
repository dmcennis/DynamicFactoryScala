import com.mcennis.dynamicfactory.BasicParameter
import com.mcennis.dynamicfactory.ParameterInternal
import com.mcennis.dynamicfactory.Parameter

import scala.reflect.runtime.universe._


object TestingObjectReferences {
  println("Welcome to the Scala worksheet")
  
  val m = Map("hello" ->BasicParameter,"here"->ParameterInternal)
  var paramA = ("hello",BasicParameter,ParameterInternal)
  val entry = m.get("hello").getOrElse(println("Not found"))
	val factories = (BasicParameter,ParameterInternal,Parameter)
   val a  = BasicParameter
  val b  = ParameterInternal
  val c  = Parameter
//  map : Map[String,(x: String): Parameter[T]] = ("Basic"->BasicParameter.create[T](x : Properties))
  def create[T](implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T]
//  def create[T](name : String, o : T*)(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o.toList)
  def create[T](name:String,o:List[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o)
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](param)
  
  def create[T](cl:String, name:String,o:List[T])(implicit tag : TypeTag[T]) : Parameter[T] = {
    if(cl.equals("BasicParameter")){
      return BasicParameter.create[T](name,o)
    }
		if(cl.equals("ParameterInternal")){
//      println("Parameter Internal Called")
      ParameterInternal.create[T](name,o)
    }
     if(cl.equals("Parameter")){
//      println("Parameter Called")
      Parameter.create[T](name,o)
    }
    return BasicParameter.create[T](name,o)
  }
 
 println("Testing");
 val t : Parameter[Int] = TestingObjectReferences.create[Int]("BasicParameter", "Default", List(2))
 
}