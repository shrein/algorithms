package org.tensorial.algo.collection.mutable

import scala.collection.mutable.Iterable

class LinkedQueue[T] extends Iterable[LinkedNode[T]] {
  var start: LinkedNode[T] = null
  var end: LinkedNode[T] = null

  def LinkedQueue(value: T) = {
    start = new LinkedNode(value, null)
    end = start
  }

  override def isEmpty = (start == null)

  def enqueue(value: T): Unit = {
    val oldEnd = end
    end = new LinkedNode(value, null)
    if (isEmpty) start = end
    oldEnd.next = end
  }

  def dequeue(): T = {
    val value = start.value
    start = start.next
    if (isEmpty) end = null
    return value
  }

  val iterator: Iterator[LinkedNode[T]] = new LinkedQueueIterator
  class LinkedQueueIterator extends Iterator[LinkedNode[T]] {
    var node: LinkedNode[T] = LinkedQueue.this.start
    def hasNext = (node == null)
    def next: LinkedNode[T] = {
      val n = node
      node = node.next
      return n
    }
  }

}