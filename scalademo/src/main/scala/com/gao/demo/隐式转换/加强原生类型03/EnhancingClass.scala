package com.gao.demo.隐式转换.加强原生类型03

import java.io.File

object EnhancingClass {
  def main(args: Array[String]): Unit = {
    import RichFunction.file2RichFile
    val read = new File("C:\\Users\\v_liangggao\\Desktop\\wc11.txt").read
    println(read)
  }

}
