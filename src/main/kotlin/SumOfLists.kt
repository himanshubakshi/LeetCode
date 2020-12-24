import kotlin.math.pow

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    var carry: Int? = null

    // Recursive
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 != null || l2 != null || carry != null) {
            val nodeValSum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + (carry ?: 0)
            val nodeVal: Int
            if (nodeValSum >= 10) {
                nodeVal = nodeValSum - 10
                carry = 1
            } else {
                nodeVal = nodeValSum
                carry = null
            }

            return ListNode(nodeVal).apply {
                next = addTwoNumbers(l1?.next, l2?.next)
            }
        }

        return null
    }

    // Iterative
    fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Node = l1
        var l2Node = l2
        var carry = 0
        var resultNode: ListNode? = null
        var temp: ListNode? = null

        while (l1Node != null || l2Node != null || carry > 0) {
            val nodeValSum = (l1Node?.`val` ?: 0) + (l2Node?.`val` ?: 0) + carry
            val nodeVal: Int
            if (nodeValSum >= 10) {
                nodeVal = nodeValSum - 10
                carry = 1
            } else {
                nodeVal = nodeValSum
                carry = null
            }

            if (resultNode == null) {
                resultNode = ListNode(nodeVal)
                temp = resultNode
            } else {
                temp?.next = ListNode(nodeVal)
                temp = temp?.next
            }

            l1Node = l1Node?.next
            l2Node = l2Node?.next
        }

        return resultNode
    }
}

class Solution1 {

    // Does not work for really long numbers
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var total = listSum(l1) + listSum(l2)

        var resultNode: ListNode? = null
        var currentNode: ListNode? = null
        if (total == 0L) {
            return ListNode(0)
        }

        while (total > 0) {
            val nodeVal = total % 10
            total /= 10

            if (resultNode == null) {
                resultNode = ListNode(nodeVal.toInt())
                currentNode = resultNode
            } else {
                currentNode?.next = ListNode(nodeVal.toInt())
                currentNode = currentNode?.next
            }
        }

        return resultNode
    }


    // Returns the int value of a list
    fun listSum(node: ListNode?, depth: Int = 0): Long {
        if (node == null) {
            return 0
        }

        return node.`val` * 10f.pow(depth).toLong() + listSum(node.next, depth + 1)
    }
}

fun main() {
    val l1 = ListNode(9).apply {
//        next = ListNode(2).apply {
//            next = ListNode(3)
//        }
    }
    val l2 = ListNode(1).apply {
        next = ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9).apply {
                        next = ListNode(9).apply {
                            next = ListNode(9).apply {
                                next = ListNode(9).apply {
                                    next = ListNode(9).apply {
                                        next = ListNode(9)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
//    val l1 = ListNode(0).apply {
//    }
//    val l2 = ListNode(0).apply {
//    }

    var resultNode = Solution().addTwoNumbers1(l1, l2)
    while (resultNode != null) {
        println(resultNode.`val`)
        resultNode = resultNode.next
    }
}
