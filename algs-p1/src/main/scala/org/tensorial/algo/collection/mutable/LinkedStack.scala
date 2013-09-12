package org.tensorial.algo.collection.mutable

import scala.collection.mutable.Iterable

class LinkedStack[T] extends Iterable[LinkedNode[T]] {
  var start: LinkedNode[T] = null

  def LinkedStack(value: T) = {
    start = new LinkedNode(value, null)
  }
  
  override def isEmpty = (start == null)

  def push(value: T): Unit = {
    start = new LinkedNode(value, start)
  }

  def pop(): T = {
    val value = start.value
    start = start.next
    return value
  }

  val iterator: Iterator[LinkedNode[T]] = new LinkedStackIterator
  class LinkedStackIterator extends Iterator[LinkedNode[T]] {
    var node: LinkedNode[T] = LinkedStack.this.start
    def hasNext = (node == null)
    def next: LinkedNode[T] = {
      val n = node
      node = node.next
      return n
    }
  }

}