package AmazonOA;

public class PriorityAllocation {
    
}


/*

allocate limited inventory items based on priority algo during flat sale in amazon customer submits request for limited qty of product eacg request has custID,
 qty, bidAmt,timestamp items are allocated using higher bids get prio if multiple customers have same bid allocate items in round robin manner based on earliest timestamp
  until all of inventory is allocated a customer gets one item per round until their req is fulfilled return ids of customer who receive no items 
  input [1,5,,5,0][2,7,8,1], [3,7,5,1][4,10,3,3] total inventory 18 output - [4]
*/