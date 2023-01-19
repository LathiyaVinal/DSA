//https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/

// Time Complexity: O(m+n) where m and n are number of nodes in first and second linked lists respectively. 

void sortedIntersect(list1,list2)
{
    while(list1 != null  &&  list2 != null)
    {
        if(list1.data == list2.data)
        {
            push(list1.data);
            list1 = list1.next;
            list2 = list2.next;
        }
        else if(list1.data < list2.data)
        list1 = list1.next;
        else
        list2 = list2.next;
    }
}
