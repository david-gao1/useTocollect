package com.gao.demo.模式匹配.option02



object MatchOption {
  def main(args: Array[String]): Unit = {
    matchAge("xiaoxiao")

  }

  def matchAge(name: String) {
    val nameAgeMap = Map("jack" -> 12, "rose" -> 13, "bob" -> 11)
    val optionAge = nameAgeMap.get(name)
    optionAge match {
      case Some(optionAge) => println(name + " get age:" + optionAge)
      case None => println("dont have nameAgeMap")
    }

  }

}
