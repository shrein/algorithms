package org.tensorial.algo.graph

class UnionFind(size: Int) {

  val elems: Array[Int] = Array.range(0,size)

  def union(p: Int, q: Int): Unit = {
    if (elems(p) != elems(q)) {
      val oldset = elems(p)
      val newset = elems(q)
      for (i <- 0 until elems.length) yield {
        if (elems(i) == oldset) {
          elems(i) = newset
        }
      }
    }
  }

  def connected(p: Int, q: Int): Boolean = {
    return (elems(p) == elems(q))
  }
}