package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._


abstract class AbstractConfigGeneric( //{//extends PropertiesImplementation{
                                      val className: Parameter[String],
                                      val shortDescription: Parameter[String],
                                      val description: Parameter[String],
                                      val longDescription: Parameter[String]) {

  val rule: Parameter[SyntaxChecker[_ <: Any]];

  def this() {
    this(
      new BasicParameter[String](
        "String",
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      new BasicParameter[String](
        "ClassName",
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      new BasicParameter[String](
        "ClassName",
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      new BasicParameter[String](
        "ClassName",
        List("Default"),
        "The Location of the name of the class to instantiate",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1))
    )
  }

  def getObject: AbstractConfigGenericSingleton;

  def merge[K](source: AbstractConfigGeneric)(implicit tag: TypeTag[K]): AbstractConfigGeneric;

  def merge[K](implicit tag: TypeTag[K]): AbstractConfigGeneric;


}

abstract class AbstractConfigGenericSingleton {
  var default: Parameter[String] = new BasicParameter[String](
    "Default",
    List("BasicParameter"),
    "The default class type created in this factory",
    "When choosing between classes of a given interface, this variant is the default if no other is chosen",
    "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1));

  var availableClasses: Parameter[(String, AbstractConfigGeneric)] = new BasicParameter[(String, AbstractConfigGeneric)](
    "availableClasses",
    List(("BasicParameter", new ConfigBasicParameter[String])),
    "The default class type created in this factory",
    "",
    "",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[(String, AbstractConfigGeneric)],1),Int.MaxValue));

  var defaultSettings: Parameter[AbstractConfigGeneric] = new BasicParameter[ConfigBasicParameter[String]](
    "Default",
    null,
    "",
    "When choosing between classes of a given interface, this variant is the default settings for the default class if no other is chosen",
    "As the master factory, this default object type configuration for what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
    null);

  var shortDescription: Parameter[String] = new BasicParameter[String](
    "shortDescription",
    List("Default"),
    "A short description suitable for a tooltip",
    "Provides a relatively short - under one sentence - designed to b displayed in a hover tooltip or other extremely short display space.",
    "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the shortest version, designed for quick, terse display of relatively small amounts of data about this object.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1));

  var description: Parameter[String] = new BasicParameter[String](
    "description",
    List("Default"),
    "A description suitable for a dialog box",
    "Provides a consise description of this object - designed to be displayed in a single dialog box with moderate space constraints.",
    "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the mid-length version, designed for on-the-fly display of relatively complete data about this object.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1));

  var longDescription: Parameter[String] = new BasicParameter[String](
    "longDescription",
    List("Default"),
    "A long description suitable for a helpfile entry",
    "Provides a lengthy, in-depth description of the object suitable for a book or extensive help file system.",
    "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the extended version, designed to provide every possible detail in extended and verbose documentation.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1));

  def getObject: Object;
}

object AbstractConfigGeneric extends AbstractConfigGenericSingleton {
  shortDescription = new BasicParameter[String](
    "ShortDescription",
    List("Default"),
    "A short description suitable for a tooltip",
    "Provides a relatively short - under one sentence - designed to b displayed in a hover tooltip or other extremely short display space.",
    "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the shortest version, designed for quick, terse display of relatively small amounts of data about this object.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1));

  description = new BasicParameter[String](
    "Description",
    List("Default"),
    "A description suitable for a dialog box",
    "Provides a consise description of this object - designed to be displayed in a single dialog box with moderate space constraints.",
    "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the mid-length version, designed for on-the-fly display of relatively complete data about this object.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1));

  longDescription = new BasicParameter[String](
    "LongDescription",
    List("Default"),
    "A long description suitable for a helpfile entry",
    "Provides a lengthy, in-depth description of the object suitable for a book or extensive help file system.",
    "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the extended version, designed to provide every possible detail in extended and verbose documentation.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)
  );

  def getObject: Object = this;
}

