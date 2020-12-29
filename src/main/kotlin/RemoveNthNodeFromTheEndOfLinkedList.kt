class RemoveNthNodeFromTheEndOfLinkedList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var nextNode: ListNode? = null
        var prevNode: ListNode? = null

        // do n hops on next
        for (i in 1..n) {
            nextNode = if (nextNode == null) head else nextNode.next
        }

        // hop both until next node points to the last node in the list
        while (nextNode?.next != null) {
            nextNode = nextNode.next
            prevNode = if (prevNode == null) head else prevNode.next
        }

        // delete prevNode.next
        if (prevNode == null) {
            prevNode = head?.next
            val temp = head
            temp?.next = null
            return prevNode
        } else {
            val temp = prevNode.next
            prevNode.next = prevNode.next?.next
            temp?.next = null
            return head
        }
    }
}