package org.tensorial.test.algo.collection.mutable

import org.tensorial.algo.collection.mutable.UnionFind
import org.scalatest._

class UnionFindTest extends FlatSpec with Matchers {
  
  "A UnionFind" should "mark as connected two set just joined" in {
    val N = 10;
    val uf = new UnionFind(N)
	val p = 1;
	val q = 2;
	uf.union(p,q);
	uf.connected(p,q) should be (true)
  } 
  
  it should "not mark as connected two sets never prevously joined" in {
    val N = 10;
    val uf = new UnionFind(N)
	val p = 1;
	val q = 2;
	val r = 3;
	uf.union(p,q);
	uf.connected(p,r) should be (false)
  }

}
