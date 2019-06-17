// Scala Programming Assessment Test

// 1.) Check for Single Even:
// Write a function that takes in an integer and returns a Boolean indicating whether
// or not it is even. See if you can write this in one line!

def SingleEven(num: Int): Boolean = {
  return num % 2 == 0
}

// 2.) Check for Evens in a List:
// Write a function that returns True if there is an even number inside of a List,
// otherwise, return False.

def CheckEvensInList(nums: List[Int]): Boolean = {
  for(num <- nums){
    if (SingleEven(num)){
      return true
    }
  }

  return false
}

// 3.) Lucky Number Seven:
// Take in a list of integers and calculate their sum. However, sevens are lucky
// and they should be counted twice, meaning their value is 14 for the sum. Assume
// the list isn't empty.

def SumOfLuckySeven(nums: List[Int]): Int = {
  var sum: Int = 0;
  for(num <- nums){
    if(num == 7){
      sum += 14
    }else{
      sum += num
    }

  }
  return sum
}

// 4.) Can you Balance?
// Given a non-empty list of integers, return true if there is a place to
// split the list so that the sum of the numbers on one side
// is equal to the sum of the numbers on the other side. For example, given the
// list (1,5,3,3) would return true, you can split it in the middle. Another
// example (7,3,4) would return true 3+4=7. Remember you just need to return the
// boolean, not the split index point.

def CanBalance(nums: List[Int]): Boolean = {
  var sum: Int = 0
  for(num <- nums){
    sum += num
  }

  if (!SingleEven(sum)){
    return false
  }else{
    var halfSum = sum/2
    sum = 0
    for(num <- nums){
      sum += num
      if (sum == halfSum)
        return true 
    }
  }

  return false
}

// 5.) Palindrome Check
// Given a String, return a boolean indicating whether or not it is a palindrome.
// (Spelled the same forwards and backwards). Try exploring methods to help you.

def isPalindrome(t: String): Boolean = {
  var i = 0
  var j = t.length - 1

  while(i <= j){

    if (i==j)
      return true

    if (t(i) != t(j)){
      return false
    }else{
      i += 1
      j -= 1
    }
  }

  return true
}
