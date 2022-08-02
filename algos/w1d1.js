var array1 = [5, 8, 6]

function totalCount(numArr){
// Write a function to return the total of the array
sum = 0
for(var i = 0; i < numArr.length; i ++){
    sum = sum + numArr[i];
}
return sum;
}
console.log(totalCount(array1))



var messages = [ "Please call back!", "Make sure you install jdk", "Help debug please!"]

function printMessages(msgArr){
// Write a function to display messages 
for(var i = 0; i < msgArr.length; i ++){
    console.log(msgArr[i])
}
}

console.log(printMessages(messages))
console.log("Hello World")