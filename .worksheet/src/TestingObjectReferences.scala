import com.mcennis.dynamicfactory.BasicParameter
import com.mcennis.dynamicfactory.ParameterInternal
import com.mcennis.dynamicfactory.Parameter

import scala.reflect.runtime.universe._


object TestingObjectReferences {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(264); 
  println("Welcome to the Scala worksheet");$skip(69); 
  
  val m = Map("hello" ->BasicParameter,"here"->ParameterInternal);System.out.println("""m  : scala.collection.immutable.Map[String,Object] = """ + $show(m ));$skip(58); 
  var paramA = ("hello",BasicParameter,ParameterInternal);System.out.println("""paramA  : (String, com.mcennis.dynamicfactory.BasicParameter.type, com.mcennis.dynamicfactory.ParameterInternal.type) = """ + $show(paramA ));$skip(61); 
  val entry = m.get("hello").getOrElse(println("Not found"));System.out.println("""entry  : Any = """ + $show(entry ));$skip(62); 
	val factories = (BasicParameter,ParameterInternal,Parameter);System.out.println("""factories  : (com.mcennis.dynamicfactory.BasicParameter.type, com.mcennis.dynamicfactory.ParameterInternal.type, com.mcennis.dynamicfactory.Parameter.type) = """ + $show(factories ));$skip(27); 
   val a  = BasicParameter;System.out.println("""a  : com.mcennis.dynamicfactory.BasicParameter.type = """ + $show(a ));$skip(29); 
  val b  = ParameterInternal;System.out.println("""b  : com.mcennis.dynamicfactory.ParameterInternal.type = """ + $show(b ));$skip(21); 
  val c  = Parameter;System.out.println("""c  : com.mcennis.dynamicfactory.Parameter.type = """ + $show(c ));$skip(187); 
//  map : Map[String,(x: String): Parameter[T]] = ("Basic"->BasicParameter.create[T](x : Properties))
  def create[T](implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T];System.out.println("""create: [T](implicit tag: reflect.runtime.universe.TypeTag[T])com.mcennis.dynamicfactory.Parameter[T]""");$skip(241); 
//  def create[T](name : String, o : T*)(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o.toList)
  def create[T](name:String,o:List[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o);System.out.println("""create: [T](name: String, o: List[T])(implicit tag: reflect.runtime.universe.TypeTag[T])com.mcennis.dynamicfactory.Parameter[T]""");$skip(113); 
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](param);System.out.println("""create: [T](param: com.mcennis.dynamicfactory.Parameter[T])(implicit tag: reflect.runtime.universe.TypeTag[T])com.mcennis.dynamicfactory.Parameter[T]""");$skip(476); 
  
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
  };System.out.println("""create: [T](cl: String, name: String, o: List[T])(implicit tag: reflect.runtime.universe.TypeTag[T])com.mcennis.dynamicfactory.Parameter[T]""");$skip(23); 
 
 println("Testing");$skip(100); ;
 val t : Parameter[Int] = TestingObjectReferences.create[Int]("BasicParameter", "Default", List(2));System.out.println("""t  : com.mcennis.dynamicfactory.Parameter[Int] = """ + $show(t ))}
 
}
