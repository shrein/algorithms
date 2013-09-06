package org.tensorial.algo.mutable.graph

/**
 * @author Juan
 *
 * Union-Find data structure for fast graph union and connection detection.
 *
 * This implementation has switched now from de quick-find to the weighted quick-union with flattening optimizations
 */
class UnionFind(size: Int) {

  val elems: Array[Int] = Array.range(0, size)
  val weight: Array[Int] = Array.fill(size)(1);

  def union(p: Int, q: Int): Unit = {

    def getRootAndFlatten(x: Int): Int = x match {
      case x if x == elems(x) => return x
      case x => {
        val parent = elems(x)
        elems(x) = elems(elems(x))
        return getRootAndFlatten(parent)
      }
    }

    val pRoot = getRootAndFlatten(p);
    val qRoot = getRootAndFlatten(q);
    if (weight(pRoot) > weight(qRoot)) {
      elems(qRoot) = pRoot
    } else {
      elems(pRoot) = qRoot
    }
    
  }

  def connected(p: Int, q: Int): Boolean = {
    
    def getRoot(x: Int): Int = x match {
      case x if x == elems(x) => return x
      case x => return getRoot(elems(x))
    }
    
    return (getRoot(p) == getRoot(q))
  }
}